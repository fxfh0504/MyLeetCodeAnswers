package com.sygan.learning.leetcode.questions.subpack3.q64;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int j=0;j<n;j++){
            for (int i=0;i<m;i++){
                if (j==0 &&i>0){
                    grid[j][i]+=grid[j][i-1];
                }else if (i==0 &&j>0){
                    grid[j][i]+=grid[j-1][i];
                }else if (i>0 &&j>0){
                    grid[j][i]+=grid[j][i-1]>grid[j-1][i]?grid[j-1][i]:grid[j][i-1];
                }
            }
        }
        return grid[n-1][m-1];
    }
}
