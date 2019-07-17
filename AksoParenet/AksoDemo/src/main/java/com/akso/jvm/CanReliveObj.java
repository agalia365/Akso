package com.akso.jvm;

public class CanReliveObj {
    public static CanReliveObj obj;
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
