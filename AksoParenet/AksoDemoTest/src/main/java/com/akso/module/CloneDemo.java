package com.akso.module;

public class CloneDemo implements Cloneable {

    private int a = 3;
    private int b = 4;

    @Override
    public String toString() {
        return "CloneDemo{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public CloneDemo clone() throws CloneNotSupportedException {
        return (CloneDemo) super.clone();

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo demo = new CloneDemo();
        CloneDemo demo2 = demo.clone();
        System.out.println(demo2);

        System.out.println(demo == demo2);
    }
}
