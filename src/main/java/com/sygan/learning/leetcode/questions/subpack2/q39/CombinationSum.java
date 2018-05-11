package com.sygan.learning.leetcode.questions.subpack2.q39;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {

    public static void main(String...args){
        System.out.println(combinationSum(new int[]{2,3,5},8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List result= new LinkedList();

        helper(candidates, target,0,result,null,0);

        return result;
    }
    public static void helper(int[] candidates, int target, int starter, List result , Queue possibility,int curr){
        if (possibility==null) possibility=new LinkedList();
        for (int i=starter;i<candidates.length;i++){
            int nextSum = candidates[i] + curr;
            if (nextSum<target) {
                Queue next = new LinkedList<>(possibility);
                next.offer(candidates[i]);
                helper(candidates, target,i,result,next,nextSum);

            }else if (nextSum==target){
                Queue next = new LinkedList<>(possibility);
                next.offer(candidates[i]);
                result.add(next);
            }else {
                break;
            }
        }

    }
}
