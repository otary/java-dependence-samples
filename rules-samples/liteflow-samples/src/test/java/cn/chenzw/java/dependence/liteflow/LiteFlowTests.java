package cn.chenzw.java.dependence.liteflow;

import com.yomahub.liteflow.builder.el.LiteFlowChainELBuilder;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.core.FlowExecutorHolder;
import com.yomahub.liteflow.flow.FlowBus;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.flow.entity.CmpStep;
import com.yomahub.liteflow.property.LiteflowConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class LiteFlowTests {

    private static FlowExecutor flowExecutor;

    @BeforeClass
    public static void init() {
        LiteflowConfig config = new LiteflowConfig();
        config.setRuleSource("flow.el.xml");

        flowExecutor = FlowExecutorHolder.loadInstance(config);
    }

    @Test
    public void test() {
        LiteflowConfig config = new LiteflowConfig();
        config.setRuleSource("flow.el.xml");

        // flowExecutor建议全局初始化一次
        FlowExecutor flowExecutor = FlowExecutorHolder.loadInstance(config);

        // 普通组件
        LiteflowResponse normalResponse = flowExecutor.execute2Resp("normal_chain", "arg");
        log.info("normalResponse => {}", normalResponse.isSuccess());

        if (!normalResponse.isSuccess()) {
            Exception e = normalResponse.getCause();
            log.info("message => {}", e.getMessage());

            Map<String, List<CmpStep>> steps = normalResponse.getExecuteSteps();
            log.info("steps => {}", steps);

            Queue<CmpStep> stepQueue = normalResponse.getExecuteStepQueue();
            log.info("stepQueue => {}", stepQueue);

            String stepStr = normalResponse.getExecuteStepStrWithTime();
            log.info("stepStrWithTime => {}", stepStr);
        }

        // 选择组件
        LiteflowResponse switchChainResponse = flowExecutor.execute2Resp("switch_chain");
        log.info("switchChainResponse => {}", switchChainResponse.isSuccess());

        // 选择组件（根据ID选择）
        LiteflowResponse switchChainResponse2 = flowExecutor.execute2Resp("switch_id_chain");
        log.info("switchChainResponse2 => {}", switchChainResponse2.isSuccess());

        // 选择组件（根据tag选择）
        LiteflowResponse switchChainResponse3 = flowExecutor.execute2Resp("switch_tag_chain");
        log.info("switchChainResponse3 => {}", switchChainResponse3.isSuccess());

        // 循环组件
        LiteflowResponse forChainResponse = flowExecutor.execute2Resp("for_chain");
        log.info("forChainResponse => {}", forChainResponse.isSuccess());

        // 条件组件
        LiteflowResponse ifChainResponse = flowExecutor.execute2Resp("if_chain");
        log.info("ifChainResponse => {}", ifChainResponse.isSuccess());

    }

    /**
     * 校验规则是否正确
     */
    @Test
    public void testValidate() {
        boolean isValid = LiteFlowChainELBuilder.validate("THEN(a, b, h)");
        log.info("isValid => {}", isValid);
    }

    @Test
    public void testReloadChain() {
        // 单独刷新某一个规则
        FlowBus.reloadChain("normal_chain", "THEN(a, b, c)");

        // 刷新所有规则
        flowExecutor.reloadRule();
    }
}
