package com.alipay.sofa;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by kevin.luy@alipay.com on 2016/12/17.
 */
public class NoThreadPoolNameDemo {
    static Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
