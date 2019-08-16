package com.akso.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "this is my callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> ft = new FutureTask<>(myCallable);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
