package com.mark.leetcode.answer.page7;

/**
 * 接雨水
 */
class Solution42 {

    /**
     * 方法一 2个指针往中间求单调栈,两边往中间找到第一个比自己矮的,然后求这一段的蓄水量,需要注意的是如果i==j了,那么必须确保对方比自己高才能计算蓄水量
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int i = 0, j = height.length - 1;
        while (i < j) {
            int start = i;
            int end = j;
            //从左往右找到第一个比自己矮的
            while (i < j && height[++i] < height[start]) {
            }
            if (i == j && height[start] > height[j]) {
                //如果i,j指针碰上了,再求一次,是不是指针j的位置比自己矮,
                // 如果比自己矮说明中间还可能有(比最低点)更高的节点,而更高影响柱子间的水量计算,所以要让自己回归初始点,从指针另一个方向计算蓄水量
                i = start;
            } else {
                //求2个柱子间蓄水量
                sumHeight(start, i, height);
            }
            while (i < j && height[--j] < height[end]) {
            }
            if (i == j && height[end] > height[i]) {
                j = end;
            } else {
                sumHeight(j, end, height);
            }
        }
        return sum;
    }

    int sum = 0;

    /**
     * 求2个柱子间的蓄水量
     *
     * @param start
     * @param end
     * @param height
     */
    public void sumHeight(int start, int end, int[] height) {
        int low = Math.min(height[start], height[end]);
        for (int i = start + 1; i < end; i++) {
            int temp = low - height[i];
            sum += temp > 0 ? temp : 0;
        }
    }

    /**
     * 方法二 动态规划方法,2个数组,第一个从左往右,计算到i为止的最高柱子;第二个从右往左,计算到i为止最高柱子.那么任意i位置的水量是两边最高值中的小的,再减去自己的高度.
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        //从左往右,计算到i为止的最高柱子
        int[] leftMaxHeight = new int[height.length];
        //从右往左,计算到i为止最高柱子
        int[] rightMaxHeight = new int[height.length];
        leftMaxHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(height[i], leftMaxHeight[i - 1]);
        }
        rightMaxHeight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(height[i], rightMaxHeight[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            //当前柱子的蓄水量,是左右2边最高柱子里,低的那个,减去自己的高度
            sum += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        }
        return sum;
    }
}