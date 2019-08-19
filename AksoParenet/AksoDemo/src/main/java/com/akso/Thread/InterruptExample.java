package com.akso.Thread;

public class InterruptExample {

    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");
    }
}
