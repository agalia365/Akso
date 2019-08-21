package com.akso.Thread;

public class MyThread extends Thread {
    public void run() {
        System.out.println("this is my thread");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
