package cn.chenzw.java.dependence.webmagic.processor;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class Yn887PageProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        System.out.println(page.getHtml());
        /*if (page.getUrl().toString().equals("http://www.yn887.com/wanjie/")) {
            processListPage(page);
        } else if (page.getUrl().regex("http://www.yn887.com/ynmh/\\d+/") != null) {
            processItemPage(page);
        }*/
    }

    public void processListPage(Page page) {
        List<Selectable> nodes =
                page.getHtml().$(".dmList>ul>li").nodes();
        for (Selectable node : nodes) {
            String link = node.$("a.pic", "href").get();
            page.addTargetRequest("http://www.yn887.com/" + link);
        }
    }

    public void processItemPage(Page page) {

        String title = page.getHtml().$("#intro_l>.title>h1", "text").get();
        System.out.println(title);

        List<Selectable> infoNodes = page.getHtml().$("#intro_l>.info>p").nodes();

        String author = infoNodes.get(1).$("a", "text").get();
        if (!StringUtils.isBlank(author)) {
            System.out.println(author);
        }

        String statusText = infoNodes.get(2).css("p", "text").get();
        System.out.println(statusText);

        String tags = infoNodes.get(4).css("p", "text").get();
        System.out.println(tags);

        System.out.println(page.getHtml().$("#intro1>p", "text").get());

        List<Selectable> nodes = page.getHtml().$(".plist>ul>li").nodes();
        for (Selectable node : nodes) {
            String href = node.$("a", "href").get();
            String name = node.$("a", "text").get();
            System.out.println(href);
            System.out.println(name);

            page.addTargetRequest("http://www.yn887.com/" + href);
        }

    }

    @Override
    public Site getSite() {
        return Site.me()
                .setTimeOut(10000)
                .setRetryTimes(2)
                .setSleepTime(100);
    }

    public static void main(String[] args) {
        Spider.create(new Yn887PageProcessor())
                .addPipeline(new ConsolePipeline())
               // .addUrl("http://www.yn887.com/wanjie/")
                .addUrl("http://www.yn887.com/ynmh/29947/627622.html?p=4")
                .run();
    }
}
