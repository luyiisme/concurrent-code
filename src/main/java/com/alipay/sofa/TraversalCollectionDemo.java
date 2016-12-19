package com.alipay.sofa;

import java.util.*;

/**
 * Created by kevin.luy@alipay.com on 2016/12/18.
 */
public class TraversalCollectionDemo {

    public static void main(String[] args) {
        nullValue();

        try {
            Set<String> set = new HashSet<String>(Arrays.asList("a", "b", "c"));
            for (String e : set) {
                if (e.equals("b")) {
                    set.remove(e);
                }
            }
        } catch (Throwable e) {
            System.err.println(e);
        }

        try {
            List<String> linkedList = new LinkedList<String>(Arrays.asList("a", "b", "c"));
            for (String e : linkedList) {
                if (e.equals("a")) {
                    linkedList.remove(e);
                }
            }
            System.out.println("remove successful,linkedList.Size:" + linkedList.size());
        } catch (Throwable e2) {
            System.err.println(e2);
        }

        try {
            List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c","d"));
            for (String e : list) {
                if (e.equals("a")) {//only "c"倒数第二个,ok
                    list.remove(e);
                }
            }
            System.out.println("remove successful,arrayList.Size:" + list.size());
        } catch (Throwable e3) {
            System.err.println(e3);
        }

    }

    private static void nullValue() {
        List list = new ArrayList<String>();
        list.add(null);
        System.out.println(list.size());

        List linkedList = new LinkedList<String>();
        linkedList.add(null);
        System.out.println(linkedList.size());

        Set set = new HashSet<>();
        set.add(null);
        System.out.println(set.size());
    }
}
