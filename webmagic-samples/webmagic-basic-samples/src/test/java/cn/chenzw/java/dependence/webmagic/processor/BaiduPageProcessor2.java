package cn.chenzw.java.dependence.webmagic.processor;

import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Slf4j
public class BaiduPageProcessor2 implements PageProcessor {

    @Override
    public void process(Page page) {
        log.info("页面处理 => {}", page.getUrl());

        page.addTargetRequest("http://help.baidu.com/newadd?prod_id=1&amp;category=4");

        log.info("页面处理完成 => {}", page.getUrl());
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setTimeOut(10000)
                .setRetryTimes(2)
                .setSleepTime(100);
    }
}
