package com.sygan.learning.leetcode.questions.subpack2.q57;

import com.sygan.learning.leetcode.questions.subpack2.q56.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.sygan.learning.leetcode.questions.subpack2.q56.MergeIntervals.Interval;

/**
 * @program: leetcode
 * @description:
 * @author: shiyu.gan
 * @create: 2019-02-24 23:54
 **/
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size()==0){
            return intervals;
        }
        Collections.sort(intervals,(o1, o2)->{
            if (o1.start-o2.start==0){
                return o1.end-o2.end;
            }else {
                return o1.start-o2.start;
            }
        });
        List<Interval> result=new ArrayList<>();
        Interval temp=intervals.get(0);
        for (int i=0;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if (curr.start<=temp.end){
                if (curr.end>temp.end){
                    temp.end=curr.end;
                }
            }else {
                result.add(temp);
                temp=curr;

            }
            if (i==intervals.size()-1){
                result.add(temp);
            }
        }
        return result;
    }
}
