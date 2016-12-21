package com.alipay.sofa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kevin.luy@alipay.com on 2016/12/18.
 */
public class E6_ParellelStreamsDemo {
    public static void main(String[] args) {
        List<Account> accounts = IntStream.range(1, 5000000).mapToObj(i -> new Account(i)).collect(Collectors.toList());

        long startTime = System.nanoTime();
        long num = accounts.stream().map(x -> x.getBalance()).filter(b -> b == 0).count();
        System.out.println(num + " seq cost:" + (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        num = accounts.parallelStream().map(x -> x.getBalance()).filter(b -> b == 0).count();
        System.out.println(num + " par cost:" + (System.nanoTime() - startTime));
    }


    static class Account {

        int balance;

        public Account(int i) {
            this.balance = i % 2 == 1 ? 0 : i;
        }

        public int getBalance() {
            return balance;
        }
    }


}
