package com.akso.Thread;

public class MyDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
        thread.start();
    }
}
