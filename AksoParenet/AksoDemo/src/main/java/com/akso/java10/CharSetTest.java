package com.akso.java10;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * java.io.PrintStream, java.io.PrintWriter 新增了构造方法
 */
public class CharSetTest {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        var str = "我是中国人";
        var p = new PrintStream("D:/aa.txt", "UTF-8");
        p.print(str);
        p.flush();
        p.close();
    }

}
