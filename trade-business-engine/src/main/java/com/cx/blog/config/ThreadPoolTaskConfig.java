package com.cx.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 1. 当一个任务被提交到线程池时，首先查看线程池的核心线程是否都在执行任务，否就选择一条线程执行任务，是就执行第二步。 2. 查看核心线程池是否已满，不满就创建一条线程执行任务，否则执行第三步。 3.
 * 查看任务队列是否已满，不满就将任务存储在任务队列中(SynchronousQueue同步队直接执行第四步)，否则执行第四步。 4. 查看线程池是否已满，不满就创建一条线程执行任务，否则就按照策略处理无法执行的任务。
 */
@Configuration
public class ThreadPoolTaskConfig {

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 此方法返回可用处理器的虚拟机的最大数量; 不小于1
        int core = Runtime.getRuntime().availableProcessors();
        // 设置核心线程数
        executor.setCorePoolSize(core);
        // 设置最大线程数
        executor.setMaxPoolSize(core * 2 + 1);
        // 除核心线程外的线程存活时间
        executor.setKeepAliveSeconds(300);
        // 如果传入值大于0，底层队列使用的是LinkedBlockingQueue,否则默认使用SynchronousQueue
        executor.setQueueCapacity(40);
        // 线程名称前缀
        executor.setThreadNamePrefix("business-thread-");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 优雅停机，等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // （默认为0，此时立即停止），并没等待xx秒后强制停止
        executor.setAwaitTerminationSeconds(50);
        return executor;
    }
}