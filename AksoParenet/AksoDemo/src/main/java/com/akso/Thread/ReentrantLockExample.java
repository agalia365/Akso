package com.akso.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private Lock lock = new ReentrantLock();

    public void fun() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        ReentrantLockExample example2 = new ReentrantLockExample();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> example.fun());
        service.execute(() -> example2.fun());
        service.shutdown();
    }

}
