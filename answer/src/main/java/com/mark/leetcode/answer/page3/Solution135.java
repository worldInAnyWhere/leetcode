package com.mark.leetcode.answer.page3;

/**
 * 分发糖果
 */
class Solution135 {
    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        int[] ratings = {1, 2, 3, 1, 0};
        System.out.println(solution135.candy(ratings));
    }

    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] result = new int[ratings.length];
        result[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            int j = i - 1;
            //只要后面的比前一个大，那么多份一个
            if (ratings[i] > ratings[j]) {
                result[i] = result[j] + 1;
            }
            if (ratings[i] <= ratings[j]) {
                //后面比前一个小，那么少分，最少只分1个。但如果前一个已经是1了，那么往前遍历直接挨个加1
                if (result[j] == 1) {
                    result[i] = 1;
                    while (j >= 0 && ratings[j + 1] < ratings[j] && result[j + 1] >= result[j]) {
                        result[j--] += 1;
                    }
                } else {
                    result[i] = 1;
                }
            }
        }
        int sum = 0;
        for (int i : result) {
            sum += i;
        }
        return sum;
    }
}