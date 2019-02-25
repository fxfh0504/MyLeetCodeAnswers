package com.sygan.learning.leetcode.questions.subpack2.q56;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public static void main(String...args){
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(4,5));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));
        merge(intervals);
    }
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size()==0){
            return intervals;
        }
        Collections.sort(intervals,(o1,o2)->{
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


    public static class Interval {
        public int start;
        public int end;

        Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
