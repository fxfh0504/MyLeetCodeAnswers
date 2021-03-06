package com.sygan.learning.leetcode.questions.subpack2.q50;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2019-02-06 13:50
 **/
public class PowXN {

    public static double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
    public static void main(String...args){
        System.out.println(myPow(2.00000,-2147483648));
    }
}
