package com.sygan.learning.leetcode.questions.subpack2.q56;


import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,(o1,o2)->o1.start-o2.start);
        return intervals;
    }


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
