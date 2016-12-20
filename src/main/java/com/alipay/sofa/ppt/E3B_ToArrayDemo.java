package com.alipay.sofa.ppt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class E3B_ToArrayDemo {

    public static void main(String[] args) {


        //toArray
        List<String> alist = new ArrayList<>();
        alist.add("a");
        alist.add("b");
        alist.add("c");

        Object[] arrays = alist.toArray();

        alist.add("d");
        for (Object e : arrays) {
            System.out.println(e);
        }
    }
}
