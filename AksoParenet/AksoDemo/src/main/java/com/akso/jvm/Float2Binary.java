package com.akso.jvm;

public class Float2Binary {
    public static void main(String[] args) {
        float a = 100.2f;
        String s = Integer.toBinaryString(Float.floatToIntBits(a));
        System.out.println(s);

        double b = 1000.2;

        String s2 = Long.toBinaryString(Double.doubleToLongBits(b));
        System.out.println(s2);
    }

    private volatile boolean stop = false;

}
