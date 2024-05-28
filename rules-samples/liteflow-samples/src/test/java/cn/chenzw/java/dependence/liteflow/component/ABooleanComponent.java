package cn.chenzw.java.dependence.liteflow.component;

import com.yomahub.liteflow.core.NodeBooleanComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenzw
 */
@Slf4j
public class ABooleanComponent extends NodeBooleanComponent {

    @Override
    public boolean processBoolean() throws Exception {
        log.info("执行A Boolean组件...");
        return true;
    }
}
