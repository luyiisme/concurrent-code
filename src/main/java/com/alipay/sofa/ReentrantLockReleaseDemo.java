package com.alipay.sofa;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kevin.luy@alipay.com on 2016/12/17.
 */
public class ReentrantLockReleaseDemo {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        lock.lock();
        try {
            System.out.println("processing");
           // throw new RuntimeException("bomb!");
        } finally {
            lock.unlock();
        }


    }
}
