package cn.chenzw.java.dependence.webmagic.support;

import lombok.Data;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池信息
 *
 * @author chenzw
 */
@Data
public class ThreadPoolInfo {

    private int activeCount;

    private int poolSize;

    private long taskCount;

    private int corePoolSize;

    private long completedTaskCount;

    private int largestPoolSize;

    private int maximumPoolSize;

    private long keepAliveTime;

    private int queueSize;

    private boolean isShutdown;

    private boolean isTerminated;

    private boolean isTerminating;

    private boolean prestartCoreThread;

    private int prestartAllCoreThreads;

    public ThreadPoolInfo(ThreadPoolExecutor threadPoolExecutor) {
        this.activeCount = threadPoolExecutor.getActiveCount();
        this.poolSize = threadPoolExecutor.getPoolSize();
        this.taskCount = threadPoolExecutor.getTaskCount();
        this.corePoolSize = threadPoolExecutor.getCorePoolSize();
        this.completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        this.largestPoolSize = threadPoolExecutor.getLargestPoolSize();
        this.maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
        this.keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.MILLISECONDS);
        this.queueSize = threadPoolExecutor.getQueue().size();
        this.isShutdown = threadPoolExecutor.isShutdown();
        this.isTerminated = threadPoolExecutor.isTerminated();
        this.isTerminating = threadPoolExecutor.isTerminating();
        this.prestartCoreThread = threadPoolExecutor.prestartCoreThread();
        this.prestartAllCoreThreads = threadPoolExecutor.prestartAllCoreThreads();
    }


}
