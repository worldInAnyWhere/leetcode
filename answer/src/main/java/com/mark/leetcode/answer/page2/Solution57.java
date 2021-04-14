package com.mark.leetcode.answer.page2;

import java.util.Arrays;

/**
 * 插入区间
 */
class Solution57 {


    /**
     * 分成三段
     * 一不和newInterval重合的
     * 二同newInterval重合的
     * 三不和newInterval重合的
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //intervals.length+1是 intervals的长度加上newInterval。就是intervals.length+1
        int[][] result = new int[intervals.length + 1][2];
        int i = 0;
        int j = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result[j++] = newInterval;
        while (i < intervals.length) {
            result[j++] = intervals[i++];
        }
        return Arrays.copyOf(result, j);
    }
}