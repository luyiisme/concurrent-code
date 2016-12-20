package com.alipay.sofa.ppt;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class E3_AsListDemo {

    public static void main(String[] args) {
        //as List
        String[] strings = new String[]{"1", "2", "3"};

        List<String> asList = Arrays.asList(strings);
        //       asList.remove(0);
        //       asList.set(1, "a");
        //       asList.add("4");


//        for (String e : strings) {
//            System.out.println(e);
//        }
    }
}
