package cn.chenzw.dependence.flowable;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * 自定义逻辑（如：调用其他系统服务）
 *
 * @author chenzw
 */
@Slf4j
// @Component(value = "callExternalSystemDelegate")
public class CallExternalSystemDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("processId => {}, currentActivityId = > {}", execution.getProcessDefinitionId(), execution.getCurrentActivityId());
        log.info("Calling the external system for employee => {}", execution.getVariable("employee"));
    }
}
