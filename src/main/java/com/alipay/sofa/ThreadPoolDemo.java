package com.alipay.sofa;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class ThreadPoolDemo {

    /**
     * 线程池demo,规约2
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = getNamedThreadFactory();

        //通用线程池
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();//gracefully shutdown

        //======================================================================================================================================================
        //单一线程线程池 例子
        //======================================================================================================================================================
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new DefaultThreadFactory("single-thread-pool-demo"), new ThreadPoolExecutor.AbortPolicy());


        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }

    /**
     * 规约9
     * @return
     */
    private static ThreadFactory getNamedThreadFactory() {
        ThreadFactory namedThreadFactory;//使用guava包中工具类；
        namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        // 使用自定义线程工厂类
        // namedThreadFactory = new DefaultThreadFactory("demo-pool");
        return namedThreadFactory;
    }

    /**
     * 自定义线程工厂类
     */
    public static class DefaultThreadFactory implements ThreadFactory {

        //工厂复用时友好
        private static final AtomicInteger poolId = new AtomicInteger();

        private final AtomicInteger nextId = new AtomicInteger();
        private final String prefix;
        private final boolean daemon;
        private final int priority;
        private final ThreadGroup threadGroup;

        public DefaultThreadFactory(String poolName) {
            this(poolName, false, Thread.NORM_PRIORITY);
        }

        public DefaultThreadFactory(String poolName, boolean daemon) {
            this(poolName, daemon, Thread.NORM_PRIORITY);
        }

        public DefaultThreadFactory(String poolName, int priority) {
            this(poolName, false, priority);
        }

        public DefaultThreadFactory(String poolName, boolean daemon, int priority) {
            this(poolName, daemon, priority, Thread.currentThread().getThreadGroup());
        }

        public DefaultThreadFactory(String poolName, boolean daemon, int priority, ThreadGroup threadGroup) {
            if (poolName == null) {
                throw new NullPointerException("poolName");
            }
            if (threadGroup == null) {
                throw new NullPointerException("threadGroup");
            }
            if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
                throw new IllegalArgumentException(
                        "priority: " + priority + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
            }

            prefix = poolName + '-' + poolId.incrementAndGet() + '-';
            this.daemon = daemon;
            this.priority = priority;
            this.threadGroup = threadGroup;
        }


        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, prefix + nextId.incrementAndGet());
            try {
                if (t.isDaemon()) {
                    if (!daemon) {
                        t.setDaemon(false);
                    }
                } else {
                    if (daemon) {
                        t.setDaemon(true);
                    }
                }

                if (t.getPriority() != priority) {
                    t.setPriority(priority);
                }
            } catch (Exception ignored) {
                // Doesn't matter even if failed to set.
            }
            return t;
        }

    }
}
