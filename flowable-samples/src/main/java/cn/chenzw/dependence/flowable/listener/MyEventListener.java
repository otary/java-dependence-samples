package cn.chenzw.dependence.flowable.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.common.engine.api.delegate.event.FlowableEventType;


/**
 * @author chenzw
 */
@Slf4j
public class MyEventListener implements FlowableEventListener {

    @Override
    public void onEvent(FlowableEvent event) {
        FlowableEventType type = event.getType();
        if (FlowableEngineEventType.JOB_EXECUTION_SUCCESS.equals(type)) {
            log.info("A job well done!");
        } else if (FlowableEngineEventType.JOB_EXECUTION_FAILURE.equals(type)) {
            log.info("A job has failed...");
        } else {
            log.info("event received => " + event.getType());
        }
    }

    @Override
    public boolean isFailOnException() {
        // false：忽略异常
        // true: 往上抛异常，使当前执行的命令失败
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}
