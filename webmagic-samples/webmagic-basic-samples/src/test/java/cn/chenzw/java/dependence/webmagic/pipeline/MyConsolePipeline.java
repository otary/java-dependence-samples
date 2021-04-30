package cn.chenzw.java.dependence.webmagic.pipeline;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

@Slf4j
public class MyConsolePipeline extends ConsolePipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        log.info("处理输出 => {}", resultItems);
    }
}
