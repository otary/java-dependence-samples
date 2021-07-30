package cn.chenzw.java.dependence.webmagic.processor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Yn887PageProcessor implements PageProcessor {

    private Pattern suffixPattern = Pattern.compile(".*\\.(jpg|png|jpeg)");

    private static final String IMAGE_ROOT_PATH = "cartoon-image";


    private OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    @Override
    public void process(Page page) {
        // System.out.println(page.getHtml());
        /*if (page.getUrl().toString().equals("http://www.yn887.com/wanjie/")) {
            processListPage(page);
        } else if (page.getUrl().regex("http://www.yn887.com/ynmh/\\d+/") != null) {
            processItemPage(page);
        }*/

        processChapterPage(page);
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

    public void processChapterPage(Page page) {
        String imagesBase64 = page.getHtml().regex("qTcms_S_m_murl_e=\"(.*?)\";").get();
        String images = new String(Base64.getMimeDecoder().decode(imagesBase64));
        String[] imagesUrls = images.split("\\$qingtiandy\\$");

        for (String imageUrl : imagesUrls) {
            Request request = new Request.Builder().url(imageUrl).build();

            try (Response response = okHttpClient.newCall(request).execute();
                 InputStream is = response.body().byteStream();
                 FileOutputStream fos = new FileOutputStream(buildImageFile(imageUrl))
            ) {
                IOUtils.copy(is, fos);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private String getImageSuffix(String url) {
        Matcher matcher =
                suffixPattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "jpg";
    }

    private File buildImageFile(String imageUrl) {
        String imageSuffix = getImageSuffix(imageUrl);
        String imageRandomName = UUID.randomUUID().toString();


        return new File(IMAGE_ROOT_PATH + imageRandomName + "." + imageSuffix);
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
