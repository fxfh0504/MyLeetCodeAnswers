package com.sygan.learning.leetcode.questions.subpack2.q40;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2018-07-10 18:03
 **/
public class CombinationSum2 {
    public static void main(String...args){
        System.out.println(combinationSum2(new int[]{2,5,2,1,2},5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> result= new LinkedList();
        helper(candidates, target,0,result,null,0);

        return result;
    }

    public static void helper(int[] candidates, int target, int starter, LinkedList<List<Integer>> result , Queue possibility, int curr){
        if (possibility==null) possibility=new LinkedList();
        if (starter==candidates.length){
            return;
        }
        for (int i=starter;i<candidates.length;i++){
            int nextSum = candidates[i] + curr;
            Queue next = new LinkedList<>(possibility);
            next.offer(candidates[i]);
            if (nextSum<target) {
                helper(candidates, target,i+1,result,next,nextSum);
            }else if (nextSum==target){
                List<Integer> last = result.peekLast();
                if (Objects.nonNull(last)&&)
                result.add(next);
            }else {
                break;
            }
        }
    }
}
