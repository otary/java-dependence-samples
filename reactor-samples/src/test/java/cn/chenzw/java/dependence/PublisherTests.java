package cn.chenzw.java.dependence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class PublisherTests {


    /**
     * 创建数据流
     */
    @Test
    public void testJust() {
        Flux.just(1, 2, 3, 4, 5);
        Mono.just(1);
    }

    /**
     * 声明
     */
    @Test
    public void testFrom() {
        // 基于数组的声明方式
        Flux.fromArray(new Integer[]{1, 2, 3, 4, 5});

        // 基于集合的声明方式
        Flux.fromIterable(Arrays.asList(1, 2, 3, 4));

        // 基于Stream的声明方式
        Flux.fromStream(Arrays.asList(1, 2, 3, 4).stream());
    }

    /**
     * 空数据流
     */
    @Test
    public void testEmpty() {
        Flux.just();
        Flux.empty();
        Mono.empty();
        Mono.justOrEmpty(Optional.empty());
    }

    /**
     * 异常数据流
     */
    @Test
    public void testError() {
        Flux.error(new Exception("some error"));
    }

    /**
     * 数据流的订阅动作
     */
    @Test
    public void testSubscribe() {
        // 测试Flux
        Flux.just(1, 2, 3, 4, 5).subscribe(System.out::print);

        System.out.println("-------------");

        // 测试Mono
        Mono.just(1).subscribe(System.out::print);

        System.out.println("-------------");

        // 测试两个参数的subscribe方法（正常数据元素、错误信号）
        Flux.just(1, 2, 3, 4).subscribe(System.out::print, System.err::print);

        System.out.println("-------------");
        // 测试3个参数（正常数据元素、错误信号、完成信号）

        // 测试4个参数（正常数据元素、错误信号、完成信号、订阅触发）
        Flux.just(1, 2, 3, 4, 5)
                .subscribe(System.out::print, System.err::println, () -> System.out.println("complete"), subscription -> {
                    System.out.println("订阅发生了");
                    subscription.request(10);
                });

    }

    /**
     * map操作符: 将数据元素转换成映射表，得到一个新的元素
     */
    @Test
    public void testMap() {
        StepVerifier.create(
                // 从1开始，步长为1，6个数据
                Flux.range(1, 6)
                        // 将元素进行立方操作
                        .map(i -> i * i * i)
        )
                // 期望值
                .expectNext(1, 8, 27, 64, 125, 216)
                // 异常情况模拟
                .expectComplete()
                .verify();
    }

    @Test
    public void testFlatMap() {
        StepVerifier.create(
                Flux.just("flux", "mono")
                        // 将每个字符串拆分成单字符的字节流
                        .flatMap(s -> Flux.fromArray(s.split("\\s*"))
                                // 对每个元素延迟100ms
                                .delayElements(Duration.ofMillis(1000))
                        )
                        // 对每个元素进行打印，doOnNext不会消费数据流（输出是异步乱序的）
                        .doOnNext(System.out::println))
                // 验证是否发出了8个元素
                .expectNextCount(8)
                .verifyComplete();
    }

    /**
     * 对数据元素过滤
     */
    @Test
    public void testFilter() {
        StepVerifier.create(
                Flux.range(1, 6)
                        // 过滤奇数
                        .filter(i -> i % 2 == 1)
                        // 过滤后的元素进行立方操作
                        .map(i -> i * i * i))
                // 期望的结果
                .expectNext(1, 27, 125)
                .verifyComplete();
    }

    /**
     * zip: 将多个流一对一的合并起来
     */
    @Test
    public void testZip() {
        StepVerifier.create(
                // 将字符串拆分为一个一个单词并以500ms/个的速度放出
                Flux.zip(Flux.fromArray("I am Reactor".split("\\s+")), Flux.interval(Duration.ofMillis(500)))
                        .doOnNext(System.out::print))
                .expectNextCount(3)
                .verifyComplete();
    }

    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void testScheduler() throws InterruptedException {

        // Callable
        Mono.fromCallable(() -> {
            TimeUnit.SECONDS.sleep(2);
            return "执行完成!";
        })
                // 弹性线程池执行
                .subscribeOn(Schedulers.elastic())
                // 异步执行完打印结果
                .subscribe(System.out::println, System.err::println);

        // Mono.fromRunnable();
        // Mono.fromSupplier();
        // Mono.fromFuture();
        Thread.sleep(3000);
    }

}
