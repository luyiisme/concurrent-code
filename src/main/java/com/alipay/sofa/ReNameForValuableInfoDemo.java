package com.alipay.sofa;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by kevin.luy@alipay.com on 2016/12/17.
 */
public class ReNameForValuableInfoDemo {
    static final Executor executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        String messageId = "123";
        executor.execute(() -> {
            final String oldName = Thread.currentThread().getName();
            Thread.currentThread().setName("sending msg-" + messageId);
            try {
                //TODO sendMsg(messageId,content)
                System.out.println("thread name:" + Thread.currentThread().getName());

            } finally {
                Thread.currentThread().setName(oldName);
            }
        });


    }

}
