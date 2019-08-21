package com.akso.Thread;

/**
 * 需要实现 run() 方法。
 * <p>
 * 通过 Thread 调用 start() 方法来启动线程。
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("this is my runnable.");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
