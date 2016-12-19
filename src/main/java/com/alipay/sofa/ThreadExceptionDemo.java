package com.alipay.sofa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kevin.luy@alipay.com on 2016/12/17.
 */
public class ThreadExceptionDemo {
    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("thread");
            }
        });
        t.start();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.print(1/0);
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        executor.shutdown();
    }
}
