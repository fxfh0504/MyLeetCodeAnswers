package com.sygan.learning.leetcode.questions.subpack2.q46;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2019-01-25 18:44
 **/

import java.util.*;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        LinkedList<List<Integer>> rest = new LinkedList<>();

        LinkedList<Integer> init = new LinkedList<>();
        for (int i :nums){
            init.add(i);
        }
        rest.add(init);
        results.add(new LinkedList<>());
        process(results,rest);
        return results;
    }

    private static void process(LinkedList<List<Integer>> results, LinkedList<List<Integer>> rest) {

        while (rest.size()>0){
            List<Integer> result = results.pop();
            List<Integer> res = rest.pop();
            for (int i=0;i<res.size();i++){
                List<Integer> result2 = copyList(result);
                List<Integer> res2 = copyList(res);
                result2.add(res2.remove(i));
                results.add(result2);
                if (res2.size()>0){
                    rest.add(res2);
                }
            }
        }

    }

    public static List<Integer> copyList(List<Integer> orig){
        ArrayList<Integer> copy = new ArrayList<>();
        copy.addAll(orig);
        return copy;
    }

    public static void main(String...args){
        List<List<Integer>> result = permute(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
