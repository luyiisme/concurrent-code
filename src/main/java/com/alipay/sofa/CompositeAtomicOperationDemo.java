package com.alipay.sofa;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kevin.luy@alipay.com on 2016/12/18.
 */
public class CompositeAtomicOperationDemo {

    public static void main(String[] args) {


    }

    ConcurrentHashMap<String, User> map = new ConcurrentHashMap<>();

    // not thread safe，even ConcurrentHashMap
    User getById(String id) {
        User user = map.get(id);
        if (user == null) {
            user = new User();
            map.put(id, user);
        }
        return user;
    }

    static class User {

    }
}
