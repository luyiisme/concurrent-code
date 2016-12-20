package com.alipay.sofa.ppt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class E2_SubListDemo {

    public static void main(String[] args) {

        List<String> alist = new ArrayList<>();
        alist.add("a");
        alist.add("b");
        alist.add("c");

        List<String> blist = alist.subList(0, 2);

        //alist.remove("b");
        // alist.add("x");
        //alist.set(1,"x");
        for (String e : blist) {
            System.err.println(e);
        }


    }
}
