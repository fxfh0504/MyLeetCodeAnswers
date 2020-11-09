package com.sygan.learning.leetcode.xjy;

import java.io.IOException;
import java.util.ArrayList;

import org.openjdk.jol.info.ClassLayout;

public class Markword {
    static volatile ArrayList<Object> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException, IOException {
        //Thread.sleep(5000L);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(123);
    }
}
