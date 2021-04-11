package com.mark.leetcode.answer.page1;

/**
 * 正则表达式匹配
 */
class Solution10 {

    public boolean isMatch(String s, String p) {
        //dp[i+1][j+1]相当于,s.substring(0,i) p.substring(0,j)是否能匹配上
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //都是空字符串的话,必然都能匹配上
        dp[0][0] = true;
        //如果s为空字符串,单独处理
        if (s.length() == 0) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    dp[0][j + 1] = dp[0][j - 1];
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    //如果相等或者为'.',那么只要前一个能匹配上就行了
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (i == 0) {
                        //如果是第一轮循环,那么'*'可以代表0个,如果是0个,就可以匹配dp[0][j-1]了
                        //其中第一轮循环可以表示s=""时,p对其的匹配情况
                        dp[0][j + 1] = dp[0][j - 1];
                    }
                    //假设'*'代表0个值.那么相当于匹配去掉'*'及其上一个值的情况
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    if ((s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        //如果已经为真,那么就可以直接为真了;再或者'*'只匹配了1个,所以是dp[i][j+1]
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i][j + 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}