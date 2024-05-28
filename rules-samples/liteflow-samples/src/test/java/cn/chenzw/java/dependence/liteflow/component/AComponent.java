package cn.chenzw.java.dependence.liteflow.component;

import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.flow.LiteflowResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenzw
 */
@Slf4j
public class AComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.info("执行A组件...");

        // 隐式调用其它chain
       /*
        LiteflowResponse response = this.invoke2Resp("c", "arg");
        if (response.isSuccess()) {
            log.info("success => {}", response.isSuccess());
        }
        */
    }
}
