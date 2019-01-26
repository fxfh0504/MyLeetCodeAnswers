package com.sygan.learning.leetcode.questions.subpack2.q46.q48;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2019-01-26 21:17
 **/

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int l = matrix.length;
        for (int j=0;j<l/2;j++){
            for (int i=j;i<l-j-1;i++){
                swap(matrix,i,j);
            }
        }
    }

    static void swap(int[][] matrix,int x,int y){
        int l = matrix.length-1;
        int a= matrix[y][x];

        matrix[y][x]=matrix[l-x][y];
        matrix[l-x][y]=matrix[l-y][l-x];
        matrix[l-y][l-x]=matrix[x][l-y];
        matrix[x][l-y]=a;

    }

    public static void main(String...args){
        int[][] ints = {new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        rotate(ints);
        System.out.println(ints);

    }
}
