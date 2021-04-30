package cn.chenzw.java.dependence.webmagic;

import cn.chenzw.java.dependence.webmagic.pipeline.MyConsolePipeline;
import cn.chenzw.java.dependence.webmagic.processor.BaiduPageProcessor;
import cn.chenzw.java.dependence.webmagic.processor.BaiduPageProcessor2;
import cn.chenzw.java.dependence.webmagic.support.ThreadPoolInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(JUnit4.class)
public class WebmagicTests {


    @Test
    public void test() throws InterruptedException {
       ThreadPoolExecutor pageProcessorThreadPool = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS,
               new LinkedBlockingQueue<>(100), new CustomizableThreadFactory("page-processor-pool-"), new RejectedExecutionHandler() {
           @Override
           public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
               log.info("线程池满了！");
           }
       });


        for (int i = 0; i < 10000; i++) {
            log.info("开始执行第{}次!", i);

            Request request = new Request();
            request.setUrl("https://www.baidu.com");
            request.setMethod(HttpConstant.Method.GET);

            Spider.create(new BaiduPageProcessor())
                            .thread(20)
                            .addRequest(request)
                            .addPipeline(new ConsolePipeline())
                            // .setDownloader(new FixSSLHttpClientDownloader(session))
                            .run(); // 同步执行
                            // .runAsync(); // 异步执行

            log.info("执行第{}次完成!", i);
            log.info("线程 => {}", new ThreadPoolInfo(pageProcessorThreadPool));
        }

        while (true) {
            Thread.sleep(3000);
        }

    }


    @Test
    public void test2() {
        Request request = new Request();
        request.setUrl("http://www.baidu.com");
        request.setMethod(HttpConstant.Method.GET);

        Spider.create(new BaiduPageProcessor2())
                .thread(20)
                .addRequest(request)
                .addPipeline(new MyConsolePipeline())
                .run(); // 同步执行
    }

}
