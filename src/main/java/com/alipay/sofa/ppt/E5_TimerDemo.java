package com.alipay.sofa.ppt;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class E5_TimerDemo {
    static volatile int i = 0;

    public static void main(String[] args) {


        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (i > 1) {
                    throw new RuntimeException("XXX");
                }
                System.out.println("aaaa");
                i++;
            }
        }, 100l, 2000l);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bbb");
            }
        }, 200l, 2000l);

        try {
            Thread.sleep(60000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
