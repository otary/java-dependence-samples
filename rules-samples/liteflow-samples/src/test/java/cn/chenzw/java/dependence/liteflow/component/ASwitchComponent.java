package cn.chenzw.java.dependence.liteflow.component;

import com.yomahub.liteflow.core.NodeSwitchComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenzw
 */
@Slf4j
public class ASwitchComponent extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        log.info("执行A Switch组件");
        return "c";
    }
}
