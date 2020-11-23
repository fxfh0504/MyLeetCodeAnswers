package com.sygan.learning.leetcode.questions.subpack3.q67.q68;

import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 *
 * Example 3:
 *
 * Input: matrix = [], target = 0
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     0 <= m, n <= 100
 *     -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }
        if (matrix[0].length==0){
            return false;
        }
        int[] ints = new int[matrix.length];
        if (matrix[0][0]>target ||matrix[matrix.length-1][matrix[0].length-1]<target){
            return false;
        }
        for (int i =0;i<matrix.length;i++){
            ints[i]=target-matrix[i][0];
        }
        int i =byteSearchGraterThanZero(ints, 0,matrix.length-1);
        if (matrix[i][0]==target){
            return true;
        }else {
            int j = Arrays.binarySearch(matrix[i], target);
            if (j>=0){
                return true;
            }
        }

        return false;
    }

    public static int byteSearchGraterThanZero(int[] ints,int a,int b){
        if (a==b){
            return a;
        }
        if (a+1==b){
            if (ints[a]==0){
                return a;
            }
            if (ints[b]==0){
                return b;
            }
            if (ints[a]>0 && ints[b]<0){
                return a;
            }else {
                return b;
            }

        }
        int middle =( a+b)/2;
        if (ints[middle]==0){
            return middle;
        }else if (ints[middle]>0){

            if (middle+1<ints.length&&ints[middle+1]<0){
                return middle;
            }else {
                return byteSearchGraterThanZero(ints,middle,b);
            }
        }else {
            if (middle-1>ints.length&&ints[middle-1]<0){
                return middle-1;
            }else {
                return byteSearchGraterThanZero(ints,a,middle);
            }
        }
    }

    public static void main(String[] args) {
        int intA[][]={{-8,-7,-6,-6,-6},{-5,-4,-3,-1,-1},{0,0,1,3,3},{5,5,6,6,6},{7,8,8,10,12},{13,15,17,17,18},{20,20,20,20,20},{22,22,22,22,23}};
        boolean b = searchMatrix(intA, 4);
        System.out.println(b);
    }
}
