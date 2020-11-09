package com.sygan.learning.leetcode.xjy;

import java.io.IOException;

public class ThreadProblems {

    public static String s ="obj";
    volatile static int i = 1;
    volatile static char j ='a';
    public static void main(String[] args) throws IOException, InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true){
                synchronized (s) {
                    s.notify();
                    if(i==27) {
                        break;
                    }
                    System.out.println(i);
                    i++;
                    try{
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread t2 = new Thread(() -> {
            while (true){
                if(j=='z'+1){
                    break;
                }
                synchronized (s) {
                    s.notify();
                    System.out.println(j);
                    j++;
                    try{
                        s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("end");
    }
}
