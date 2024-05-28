package cn.chenzw.java.dependence.liteflow.component;

import com.yomahub.liteflow.core.NodeForComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenzw
 */
@Slf4j
public class AForComponent extends NodeForComponent {

    @Override
    public int processFor() throws Exception {
        log.info("执行A for循环组件...");
        // 返回后面执行的次数
        return 2;
    }
}
