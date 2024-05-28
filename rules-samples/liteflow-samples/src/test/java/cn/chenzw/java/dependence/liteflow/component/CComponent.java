package cn.chenzw.java.dependence.liteflow.component;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenzw
 */
@Slf4j
public class CComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.info("执行C组件...");

        // 获取上个步骤抛出的异常（CATCH...DO）
        Exception exception = this.getSlot().getException();

        // 获取入参值
        Object requestData = this.getRequestData();
    }
}
