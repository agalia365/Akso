package com.akso.java10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * java.io.ByteArrayOutputStream.toString(charset)
 */
public class ToStringTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        var str = "我是中国人";

        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("gbk"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int c = 0;
        while((c = bis.read()) != -1) {
            bos.write(c);
        }
        // bos.toString()默认使用的是UTF-8
        System.out.println(bos.toString("gbk"));
    }
}
