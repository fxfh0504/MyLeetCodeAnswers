package com.sygan.learning.leetcode.questions.q29;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-02-07
 * @Time: 14:54
 */

/**
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        long ans=0;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        while(n>=d){
            long a=d;
            long m=1;
            while((a<<1) < n){a<<=1;m<<=1;}
            ans+=m;
            n-=a;
        }
        if((dividend<0&&divisor>=0)||(dividend>=0&&divisor<0))
            return (int)-ans;
        return (int)ans;
    }
}
