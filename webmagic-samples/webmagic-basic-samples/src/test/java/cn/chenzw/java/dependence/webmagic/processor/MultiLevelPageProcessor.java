package cn.chenzw.java.dependence.webmagic.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * 多层页面处理
 *
 * @author chenzw
 */
public class MultiLevelPageProcessor implements PageProcessor {

    @Override
    public void process(Page page) {
        if (page.getUrl().toString().equals("https://www.kuaikanmanhua.com/tag/0")) {
            processListPage(page);
        } else if (page.getUrl().regex("https://www.kuaikanmanhua.com/web/topic/.*") != null) {
            processChapterListPage(page);
        }

    }

    private void processListPage(Page page) {
        List<Selectable> nodes = page.getHtml().$(".tagContent>.ItemSpecial").nodes();
        for (Selectable node : nodes) {
            page.addTargetRequest("https://www.kuaikanmanhua.com/" + node.$("a.itemLink", "href").get());
        }
    }

    private void processChapterListPage(Page page) {

        System.out.println(page.getHtml());

        // 漫画名称
        String title = page.getHtml().$(".TopicHeader>.right>.title", "text").get();
        String nickName = page.getHtml().$(".TopicHeader>.right>.nickname", "text").get();
        String detail =  page.getHtml().$(".TopicHeader>.right .detailsBox>p", "text").get();
        String imageCover = page.getHtml().$(".TopicHeader>.left>.imgCover", "data-src").get();

        System.out.println(imageCover);

        List<Selectable> nodes = page.getHtml().$(".TopicList .TopicItem").nodes();
        for (Selectable node : nodes) {


            // 章节标题
            String chapterTitle = node.$(".title>a>span", "text").get();
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
        Spider.create(new MultiLevelPageProcessor())
                .addPipeline(new ConsolePipeline())
                //.addUrl("https://www.toho8.cn/update/")
                .addUrl("https://www.kuaikanmanhua.com/tag/0")
                .run();
    }
}
