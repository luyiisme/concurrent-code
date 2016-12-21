package com.alipay.sofa.ppt;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class E5B_ScheduleThreadPoolDemo {
    static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(1, namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        ScheduledFuture future = pool.scheduleAtFixedRate(() -> {
            if (i > 1) {
                throw new RuntimeException("XXX");
            }
            System.out.println("aaaa");
            i++;
        }, 100l, 2000l, TimeUnit.MILLISECONDS);

        pool.scheduleAtFixedRate(() -> System.out.println("bbbb"), 100l, 2000l, TimeUnit.MILLISECONDS);

        try {
            future.get();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }

        Thread.sleep(8000l);

        pool.shutdown();
    }
}
