package cn.chenzw.dependence.flowable;

import cn.chenzw.dependence.flowable.listener.MyEventListener;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenzw
 */
@Slf4j
public class HolidayProcess {

    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setEventListeners(Arrays.asList(new MyEventListener()))
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        // 将流程定义部署至Flowable引擎
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .deploy();

        // 查询已部署的流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        log.info("Found process definition :  => {}", processDefinition.getName());

        // 启动流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<>(); // 设置变量
        variables.put("employee", "zhangsan");
        variables.put("nrOfHolidays", "1");
        variables.put("description", "release");
        // 执行 id=holidayRequest 的 process
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);

        // 查询任务列表（此处只查询’managers’组的任务）
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery()
                // .taskAssignee("kermit")
                // .processVariableValueEquals("orderId", "0815")
                .taskCandidateGroup("managers")
                .list();
        log.info("You have {} tasks！task list => {}", tasks.size(),
                tasks.stream().map((task) -> task.getName()).collect(Collectors.toList())
        );

        // 获取指定流程实例的变量
        Task task = tasks.get(0);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        log.info("{} wants {} of holidays. Do you approve this?", processVariables.get("employee"), processVariables.get("nrOfHolidays"));

        // 完成任务0（id=approveTask）
        taskService.complete(task.getId(), new HashMap<String, Object>() {
            {
                put("approved", true);  // 设置变量值approved
            }
        });

        // 查看流程实例已经执行的时间
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

        // 获取表数据
        ManagementService managementService = processEngine.getManagementService();
        String tableName = managementService.getTableName(Task.class);
        log.info("tableName => {}", tableName);
        List<Task> tasks2 = taskService.createNativeTaskQuery()
                .sql("SELECT count(*) FROM " + managementService.getTableName(Task.class) +
                        " T WHERE T.NAME_ = #{taskName}")
                .parameter("taskName", "gonzoTask")
                .list();
        log.info("tasks => {}", tasks2);

        // 其它
        IdentityService identityService = processEngine.getIdentityService();
        FormService formService = processEngine.getFormService();
        DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();


    }

}
