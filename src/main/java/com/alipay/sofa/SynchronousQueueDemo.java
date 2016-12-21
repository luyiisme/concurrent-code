package com.alipay.sofa;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by kevin.luy@alipay.com on 2016/12/20.
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue synchronousQueue = new SynchronousQueue();
        synchronousQueue.add("E");
        synchronousQueue.put("E");

        System.out.println(synchronousQueue.offer("E"));

    }
}
