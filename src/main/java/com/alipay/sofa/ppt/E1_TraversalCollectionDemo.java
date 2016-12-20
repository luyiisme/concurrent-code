package com.alipay.sofa.ppt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kevin.luy@alipay.com on 2016/12/19.
 */
public class E1_TraversalCollectionDemo {

    public static void main(String[] args) {

        try {
            List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
            for (String e : list) {
                if (e.equals("d")) {
                    list.remove(e);
                }
            }
            System.out.println("remove successful,arrayList.Size:" + list.size());
        } catch (Throwable e3) {
            e3.printStackTrace();
        }
    }
}
