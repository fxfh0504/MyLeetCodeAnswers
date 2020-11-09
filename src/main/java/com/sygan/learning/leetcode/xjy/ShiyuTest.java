package com.sygan.learning.leetcode.xjy;

public class ShiyuTest {


    private long l1,l2,l3,l4,l5,l6,l7;
    public  int o = 0;
    private long l11,l12,l13,l14,l15,l16,l17;

    public static void main(String[] args) throws InterruptedException {

        ShiyuTest t1 = new ShiyuTest();
        ShiyuTest t2 = new ShiyuTest();
        long now = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 100000000; i++) {
                synchronized (t1) {
                    t1.o+=1;
                }
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 100000000; i++) {
                synchronized (t2) {
                    t2.o+=1;
                }
            }

        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        long end = System.currentTimeMillis();
        System.out.println(end - now);
    }
}
