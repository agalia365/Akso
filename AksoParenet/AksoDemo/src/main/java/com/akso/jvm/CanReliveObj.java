package com.akso.jvm;

public class CanReliveObj {
    public static CanReliveObj obj;
    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
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

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("Can Relive Obj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am can alive obj";
    }
}
