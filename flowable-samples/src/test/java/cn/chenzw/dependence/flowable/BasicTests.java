package cn.chenzw.dependence.flowable;


import cn.chenzw.dependence.flowable.listener.MyEventListener;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.*;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.validation.ProcessValidator;
import org.flowable.validation.ProcessValidatorFactory;
import org.flowable.validation.ValidationError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class BasicTests {


    @Autowired
    private RepositoryService repositoryService;


    /**
     * 通过代码创建BpmnModel
     */
    @Test
    public void testCreateBpmnModel() throws IOException {
        BpmnModel bpmnModel = new BpmnModel();

        // 对应于<process>标签
        Process process = new Process();
        process.setId("test");

        // 对应于<startEvent>标签
        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        startEvent.setName("开始");
        // startEvent.setAsynchronous(true);
        startEvent.setExclusive(true);
        addFlowNode(bpmnModel, startEvent, 0, 0);
        process.addFlowElement(startEvent);

        // 对应于<userTask>标签
        UserTask userTask = new UserTask();
        userTask.setId("myTask1");
        userTask.setName("myTask1");
        userTask.setAssignee("chenzw");
        addFlowNode(bpmnModel, userTask, 0, 100);
        process.addFlowElement(userTask);

        // 顺序线
        addSequenceFlow(bpmnModel, process, startEvent, userTask);

        // 服务
        ServiceTask serviceTask = new ServiceTask();
        serviceTask.setId("myService1");
        serviceTask.setName("调用服务");
        // serviceTask.setAsynchronous(true);
        serviceTask.setExclusive(true);
        // serviceTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION);
        // serviceTask.setImplementation("${callExternalSystemDelegate}");
        serviceTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_CLASS);
        serviceTask.setImplementation("cn.chenzw.dependence.flowable.CallExternalSystemDelegate");
        addFlowNode(bpmnModel, serviceTask, 0, 200);
        process.addFlowElement(serviceTask);

        // 顺序线
        addSequenceFlow(bpmnModel, process, userTask, serviceTask);

        // 对应于<endEvent>标签
        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        endEvent.setName("结束");
        addFlowNode(bpmnModel, endEvent, 0, 300);
        process.addFlowElement(endEvent);

        // 顺序线
        addSequenceFlow(bpmnModel, process, serviceTask, endEvent);

        bpmnModel.addProcess(process);

        // 流程校验
        ProcessValidator processValidator = new ProcessValidatorFactory().createDefaultProcessValidator();
        List<ValidationError> validationErrorList = processValidator.validate(bpmnModel);
        if (validationErrorList.size() > 0) {
            throw new RuntimeException("流程有误，请检查后重试");
        }

        log.info("bpmn.xml => {}", new String(new BpmnXMLConverter().convertToXML(bpmnModel)));

        try (FileOutputStream fos = new FileOutputStream("test.bpmn20.xml")) {
            fos.write(new BpmnXMLConverter().convertToXML(bpmnModel));
        }

        ProcessEngine processEngine = new StandaloneProcessEngineConfiguration()
                .setEventListeners(Arrays.asList(new MyEventListener()))
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                //.addClasspathResource("test.bpmn20.xml")
                .addBpmnModel("1.bpmn", bpmnModel)
                .key("test")
                .name("测试")
                .category("app")
                // .disableBpmnValidation()
                // .disableSchemaValidation()
                // .tenantId("admin")
                .deploy();

        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : processDefinitions) {
            log.info("processDefinition => id = {}, key = {}", processDefinition.getId(), processDefinition.getKey());
        }

        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("test");

        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .list();
        log.info("You have {} tasks！task list => {}", tasks.size(),
                tasks.stream().map((task) -> task.getName()).collect(Collectors.toList())
        );

        Task task = taskService.createTaskQuery().taskAssignee("chenzw").singleResult();
        log.info("complete task => {}", task);
        taskService.complete(task.getId());


        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(processInstance.getId())
                        .finished()
                        .orderByHistoricActivityInstanceEndTime().asc()
                        .list();

        for (HistoricActivityInstance activity : activities) {
            log.info("{} took {} milliseconds", activity.getActivityId(), activity.getDurationInMillis());
        }

    }

    private void addFlowNode(BpmnModel bpmnModel, FlowNode node, Integer xPosition, Integer yPosition) {
        GraphicInfo graphicInfo = new GraphicInfo(xPosition, yPosition, 50, 100);
        bpmnModel.addGraphicInfo(node.getId(), graphicInfo);
    }

    private SequenceFlow addSequenceFlow(BpmnModel bpmnModel, Process process, FlowNode sourceNode, FlowNode targetNode) {
        SequenceFlow sequenceFlow = new SequenceFlow(sourceNode.getId(), targetNode.getId());
        sequenceFlow.setId(sourceNode.getId() + "-" + targetNode.getId());
        sourceNode.getOutgoingFlows().add(sequenceFlow);
        targetNode.getIncomingFlows().add(sequenceFlow);
        process.addFlowElement(sequenceFlow);
        bpmnModel.addFlowGraphicInfoList(sequenceFlow.getId(), getFlowGraphicInfoList(bpmnModel, sequenceFlow, sourceNode, targetNode));
        return sequenceFlow;
    }

    private List<GraphicInfo> getFlowGraphicInfoList(BpmnModel bpmnModel, SequenceFlow sequenceFlow, FlowNode sourceNode, FlowNode targetNode) {
        List<GraphicInfo> graphicInfoList = new ArrayList<>();
        GraphicInfo sourceGraphicInfo = bpmnModel.getLocationMap().get(sourceNode.getId());
        GraphicInfo targetGraphicInfo = bpmnModel.getLocationMap().get(targetNode.getId());
        if (targetNode instanceof EndEvent) {
            sequenceFlow.setName("end");
            graphicInfoList.add(new GraphicInfo(sourceGraphicInfo.getX() + sourceGraphicInfo.getWidth() / 2,
                    sourceGraphicInfo.getY() + sourceGraphicInfo.getHeight(),
                    sourceGraphicInfo.getHeight(), sourceGraphicInfo.getWidth()));
            graphicInfoList.add(new GraphicInfo(sourceGraphicInfo.getX() + sourceGraphicInfo.getWidth() / 2,
                    targetGraphicInfo.getY() + targetGraphicInfo.getHeight() / 2, sourceGraphicInfo.getHeight(), sourceGraphicInfo.getWidth()));
            graphicInfoList.add(new GraphicInfo(targetGraphicInfo.getX() + targetGraphicInfo.getWidth(),
                    targetGraphicInfo.getY() + targetGraphicInfo.getHeight() / 2, targetGraphicInfo.getHeight(), targetGraphicInfo.getWidth()));
        } else {
            graphicInfoList.add(new GraphicInfo(sourceGraphicInfo.getX() + sourceGraphicInfo.getWidth(),
                    sourceGraphicInfo.getY() + sourceGraphicInfo.getHeight() / 2, sourceGraphicInfo.getHeight(), sourceGraphicInfo.getWidth()));
            graphicInfoList.add(new GraphicInfo(targetGraphicInfo.getX(), targetGraphicInfo.getY() + targetGraphicInfo.getHeight() / 2,
                    targetGraphicInfo.getHeight(), targetGraphicInfo.getWidth()));
        }
        return graphicInfoList;
    }
}
