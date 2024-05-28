package cn.chenzw.java.dependence.liteflow.component;

import cn.hutool.core.collection.ListUtil;
import com.yomahub.liteflow.core.NodeIteratorComponent;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenzw
 */
@Slf4j
public class AIteratorComponent extends NodeIteratorComponent {

    @Override
    public Iterator<?> processIterator() throws Exception {
        log.info("执行A Iterator组件...");
        List<String> list = Arrays.asList("jack", "mary", "tom");
        return list.iterator();
    }
}
