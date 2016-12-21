package com.alipay.sofa.ppt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kevin.luy@alipay.com on 2016/12/21.
 */
public class E1B_TraversalRemoveDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("b".equals(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
