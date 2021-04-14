package com.mark.leetcode.answer.page2;

/**
 * 颜色分类
 * 我的解法不巧妙，但是非常简单一看就懂
 */
class Solution75 {
    public void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                i++;
            } else if (nums[k] == 2) {
                j--;
            }
        }
        for (int k = 0; k <= j; k++) {
            if (k <= i) {
                nums[k] = 0;
            } else if (k <= j) {
                nums[k] = 1;
            } else {
                nums[k] = 2;
            }
        }
    }
}