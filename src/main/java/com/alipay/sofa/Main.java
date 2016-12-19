package com.alipay.sofa;

import java.io.IOException;

/**
 * Created by kevin.luy@alipay.com on 2016/12/15.
 */
public class Main {

    volatile int a;

    public static void main(String[] args) throws IOException {

        new Thread("demo");

        new Thread(()->{

            try{

            }finally {

            }
        });




        Thread t2 = new Thread();
        t2.start();
        t2.setName("demo2");
        System.out.println(t2.getName());


        Thread.currentThread().setName("demo3");
        System.out.println(Thread.currentThread().getName());
    }
}
