package com.akso.jvm;

public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        CanReliveObj obj = new CanReliveObj();
        obj = null; // 可复活

        System.gc();

        Thread.sleep(1000);
        if(obj == null) {
            System.out.println("obj is null");
        } else {
            System.out.println("obj is live");
        }

        System.out.println("第二次调用GC");
        obj = null; //不可复活
        System.gc();

        Thread.sleep(1000);
        if(obj == null) {
            System.out.println("obj is null");
        } else {
            System.out.println("obj is live");
        }


    }


}
