package com.akso.java10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * java.util.Formatter, java.util.Scanner
 */
public class ScannerTest {
    public static void main(String[] args) throws FileNotFoundException {
        var scan = new Scanner(new FileInputStream(new File("D:/aa.txt")), "UTF-8");
//        while(scan.hasNext()) {
//            System.out.println(scan.nextLine());
//        }
        scan.useDelimiter(",| ");
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
    }
}
