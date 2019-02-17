package com.sygan.learning.leetcode.questions.subpack2.q54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]s
 */
public class SpiralMatrix {
    public static void main(String...args){
//        int[][] input = {
//                {1, 2, 3,4}, { 5, 6,7,8}, {9,10,11,12}};
        int[][] input = {{1}
                };
        System.out.println(spiralOrder(input));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length-1;
        if (matrix.length==0){
            return Collections.EMPTY_LIST;
        }
        int m = matrix[0].length-1;
        if (m<0){
            return Collections.EMPTY_LIST;
        }
        int i=0,j=0;
        List<Integer> result=new ArrayList<>();
        int flag=1;
        int flag2=0;
        while (matrix[j][i]>Integer.MIN_VALUE){
            result.add(matrix[j][i]);
            matrix[j][i]=Integer.MIN_VALUE;

            switch (flag){
                case 1:{
                    if (i+1>m-flag2){
                        flag=2;
                        if (j+1<=n-flag2){
                            j++;
                        }
                    }else {
                        i++;
                    }

                    break;
                }case 2:{
                    if (j+1>n-flag2){
                         flag=3;
                        if (i-1>=0+flag2){
                            i--;
                        }
                    }else {
                        j++;
                    }
                    break;
                }case 3:{
                    if (i-1<0+flag2){
                        flag=4;
                        flag2+=1;
                        if (j-1>=0+flag2) {
                            j--;
                        }
                    }else {
                        i--;
                    }
                    break;
                }case 4:{
                    if (j-1<0+flag2){
                        flag=1;
                        i++;
                    }else {
                        j--;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
