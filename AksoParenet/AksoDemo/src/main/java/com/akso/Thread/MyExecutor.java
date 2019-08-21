package com.akso.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());

        }
        executorService.shutdown();

        System.out.println("------------");
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService1.execute(new MyRunnable());
        }
        executorService1.shutdown();

        System.out.println("------------");
        ExecutorService executorService12 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService12.execute(new MyRunnable());
        }
        executorService12.shutdown();
    }
}
