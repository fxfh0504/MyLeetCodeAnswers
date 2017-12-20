package com.sygan.learning.leetcode.questions.q4;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2017-12-20
 * @Time: 14:51
 */

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */

/**
 *
 * 遇到的难题有解决输入的数组可能为0的情况
 * 将这个问题想办法解决后就迎刃而解
 */
public class MedianofTwoSortedArrays {
    public static void main(String...args){
        int[] a = new int[]{};
        int[] b = new int[]{2,3};
        double result = findMedianSortedArrays(a,b);
        System.out.println(result);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length,a,b;
        Integer median =(m+n)/2+1;
        boolean flag=(m+n)%2==1;
        int pre=0,curr=0;
        for (int i=0,j=0;i<=m&j<=n;){
            pre=curr;
            a=(isAcceptable(nums1,i)?Integer.MAX_VALUE:nums1[i]);
            b=(isAcceptable(nums2,j)?Integer.MAX_VALUE:nums2[j]);
            if (a<=b){
                curr=a;
                if (i<m){
                    i++;
                }
            }else {
                curr=b;
                if (j<n){
                    j++;
                }
            }
            if (flag&&median.equals(i+j)){
                return curr;
            }else if((median.equals(i+j))&&!flag){
                return (pre+curr)/2.0;
            }
        }
        return 0;
    }
    public static boolean isAcceptable(int[] ints,int i){
        if (ints.length>0&&i<ints.length){
             return false;
        }else {
            return true;
        }
    }
}
