package cn.chenzw.java.dependence.liteflow.component;

import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenzw
 */
@Slf4j
public class AComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.info("执行A组件...");
    }
}
