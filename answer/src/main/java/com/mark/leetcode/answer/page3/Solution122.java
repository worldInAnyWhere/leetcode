package com.mark.leetcode.answer.page3;

/**
 * 买卖股票的最佳时机 II
 */
class Solution122 {
    public int maxProfit(int[] prices) {
        boolean isSale = false;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (!isSale) {
                if (prices[i] > prices[i - 1]) {
                    result -= prices[i - 1];
                    if (i == prices.length -1){
                        result += prices[i];
                        break;
                    }
                    isSale = true;
                }
            } else {
                if (prices[i] < prices[i - 1]) {
                    result += prices[i - 1];
                    isSale = false;
                } else if (i == prices.length - 1) {
                    result += prices[i];
                }
            }
        }
        return result;
    }
}