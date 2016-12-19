package com.alipay.sofa;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by kevin.luy@alipay.com on 2016/12/18.
 */
public class LongAdderDemo {

    public static void main(String[] args) {

        useAtomicLong();

        System.out.println("use longAdder ==>");
        LongAdder longAdder = new LongAdder();
        longAdder.add(2);
        //add 1
        longAdder.increment();
        System.out.println(longAdder.sum());

        longAdder.add(10);
        System.out.println(longAdder.sum());

        System.out.println("use longAccumulator ==>");
        //prev =13. cur=100
        LongAccumulator longAccumulator = new LongAccumulator((prev, cur) -> prev * cur, 13);

        longAccumulator.accumulate(100);
        System.out.println(longAccumulator.get());


    }

    private static void useAtomicLong() {
        System.out.println("use atomLong ==>");
        AtomicLong atomicLong = new AtomicLong(2);
        //current=2
        System.out.println(atomicLong.incrementAndGet());
        //一元计算：x=3
        System.out.println(atomicLong.updateAndGet(x -> x + 10));// addAndGet(10)
        //二元计算：prev=13, current=100;
        System.out.println(atomicLong.accumulateAndGet(100, (prev, cur) -> prev * cur));
    }


}
