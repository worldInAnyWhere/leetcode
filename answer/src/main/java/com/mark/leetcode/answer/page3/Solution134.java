package com.mark.leetcode.answer.page3;

/**
 * 加油站
 */
class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (cost[i] <= gas[i]) {
                if (canCompleteCircuitFromStart(gas, cost, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean canCompleteCircuitFromStart(int[] gas, int[] cost, int start) {
        int length = gas.length;
        int now = start;
        int sum = 0;
        do {
            sum += gas[now] - cost[now];
            if (sum < 0) {
                return false;
            }
            now++;
            if (now >= length) {
                now = 0;
            }
        } while (now != start);
        return true;
    }
}