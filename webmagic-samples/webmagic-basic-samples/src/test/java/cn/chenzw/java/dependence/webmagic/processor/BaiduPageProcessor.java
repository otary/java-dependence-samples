package cn.chenzw.java.dependence.webmagic.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BaiduPageProcessor implements PageProcessor {



    @Override
    public void process(Page page) {

        log.info("页面处理 => ");
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setTimeOut(10000)
                .setRetryTimes(2)
                .setSleepTime(100);
    }
}
