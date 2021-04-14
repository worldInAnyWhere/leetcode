package com.mark.leetcode.answer.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 这道题，看到第一眼其实卡了，感觉比较费劲。看了下答案发现很简单，排序，然后依次合并区间即可。重点是第一步要排序，只要有序，后面就好做了。
 */
class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<int[]>();
        int[] toMerge = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= toMerge[1]) {
                if (intervals[i][1] > toMerge[1]) {
                    toMerge[1] = intervals[i][1];
                }
                if (i == intervals.length - 1) {
                    result.add(toMerge);
                }
            } else {
                result.add(toMerge);
                if (i == intervals.length - 1) {
                    result.add(intervals[i]);
                } else {
                    toMerge = intervals[i];
                }
            }
        }
        return result.toArray(new int[0][2]);
    }
}