package com.alipay.sofa;

import java.util.concurrent.*;

/**
 * Created by kevin.luy@alipay.com on 2016/12/18.
 */
public class FutureUsageDemo {

    static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        futureMain(args);

        System.out.println("\n commpletable future demo====>\n");

        completableFutureMain(args);

        pool.shutdown();
    }


    static void futureMain(String[] args) {

        Future<String> future = pool.submit(() -> {
            System.out.println("processing...");
            Thread.sleep(3000);
            return "hello world!";
        });
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("processed: " + result);


        System.out.println("do other things!");

    }

    static void completableFutureMain(String[] args) {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("processing...");
//            throw new RuntimeException("d");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world!";
        }, pool);

        completableFuture.thenApply(result -> {
            System.out.println("processed: " + result);
            return null;
        }).exceptionally(e -> {
            System.err.println(e);
            return null;
        });

        //  completableFuture.thenAccept(result -> System.out.println("processed: " + result));


// pool already shutdown;
//        completableFuture.thenApplyAsync(result ->
//            System.out.println("processed: " + result);
//            return null;
//        },pool);
        System.out.println("do other things!");


        //fluent program
        // completableFuture.whenComplete().thenApply().thenAccept().thenRun();

    }
}
