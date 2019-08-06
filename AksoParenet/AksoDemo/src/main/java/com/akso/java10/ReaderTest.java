package com.akso.java10;

import java.io.*;

/**
 * Reader.transferTo方法
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/aa.txt"), "UTF-8"));
        var p = new PrintWriter(new FileOutputStream("D:/cc.txt"));
        reader.transferTo(p);
        p.flush();
        p.close();
        reader.close();
    }
}
