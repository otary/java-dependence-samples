package cn.chenzw.java.guava.concurrent;

import com.google.common.util.concurrent.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(JUnit4.class)
public class MoreExecutorsTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 构造Guava线程池，支持异步回调
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        for (int i = 0; i < 5; i++) {
            ListenableFuture<String> jobFutrue = listeningExecutorService.submit(new MyJob(i));

            // 绑定异步回调
            Futures.addCallback(jobFutrue, new FutureCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    logger.info("Execute success with result: {}", result);
                }

                @Override
                public void onFailure(Throwable t) {
                    logger.error("Execute failure with exception: {}", t);
                }
            });
        }

        // 阻塞
        Thread.sleep(3000);
    }


    public static class MyJob implements Callable<String> {
        private Logger logger = LoggerFactory.getLogger(getClass());

        private int id;

        public MyJob(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            logger.info("Job [{}] running...", id);
            return "Job [" + id + "] Finish!";
        }
    }
}
