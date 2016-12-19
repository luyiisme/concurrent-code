package com.alipay.sofa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kevin.luy@alipay.com on 2016/12/18.
 */
public class SingleThreadpoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("s");
        });
        //use new Thread;
        pool.execute(() -> System.out.println(Thread.currentThread().getName()));

        pool.shutdown();
    }
}
