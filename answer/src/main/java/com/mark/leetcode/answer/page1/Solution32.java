package com.mark.leetcode.answer.page1;

import java.util.LinkedList;

/**
 * 最长有效括号
 */
class Solution32 {

    public int longestValidParentheses(String s) {
        //数字表示从这个位置往前几个都是完整的括号对
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (')' == s.charAt(i)) {
                if ('(' == s.charAt(i - 1)) {
                    //如果和前一个匹配括号,那么就是前1个的长度+2
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    max = Math.max(dp[i], max);
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && '(' == s.charAt(i - dp[i - 1] - 1)) {
                        //排除了i,向左边数dp[i-1]长度,即长度dp[i-1]都是符合括号对的
                        if (i - dp[i - 1] - 2 >= 0) {
                            //dp[i-dp[i-1]-2]是当前连起来的这些,再往前还有没有括号,注意防止数组越界
                            //dp[i-1]+2是当前连起来的的最长括号
                            dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                        max = Math.max(dp[i], max);
                    }
                }
            }
        }
        return max;
    }
}