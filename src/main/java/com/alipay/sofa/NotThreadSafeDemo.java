package com.alipay.sofa;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class NotThreadSafeDemo {
    static int size;

    public static void main(String[] args) {


        for(int i=0;i<1000;i++){
            size++;
        }
    }


}
