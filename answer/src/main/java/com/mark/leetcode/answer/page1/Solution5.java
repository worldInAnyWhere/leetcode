package com.mark.leetcode.answer.page1;

/**
 * 最长子回文数
 */
class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        //存储从i到j是否是子回文数
        boolean[][] dp = new boolean[n][n];
        String result = "";
        //padding = j - i,padding从0遍历到s的长度
        for (int padding = 0; padding < s.length(); padding++) {
            for (int i = 0; i + padding < n; i++) {
                int j = i + padding;
                if (padding == 0) {
                    //如果为0,则必是子回文数
                    dp[i][j] = true;
                } else if (padding == 1) {
                    //如果为1,则判断第i个和第j个字符是否相等.
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    //如果超过1,则两边字符相等的同时,他们夹着的那个字符串必须是回文数
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && padding >= result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}