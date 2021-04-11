package com.mark.leetcode.answer.page28;

import com.mark.leetcode.answer.base.TreeNode;

/**
 * 二叉搜索子树的最大键值和
 */
class Solution1373 {
    private int maxValue = 0;

    /**
     * 方法一
     *
     * @param root
     * @return
     */
    public int maxSumBST1(TreeNode root) {
        help(root);
        return maxValue;
    }

    /**
     *
     * @param root
     * @return int[] 数组有3个值,分别是子树下最大值,最小值,当前和
     */
    public int[] help(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        if (root.val > left[1] && root.val < right[0]) {
            int sum = root.val + left[2] + right[2];
            maxValue = Math.max(maxValue, sum);
            return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), sum};
        }

        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }

    /**
     * 方法二
     *
     * @param root
     * @return
     */
    public int maxSumBST2(TreeNode root) {
        if (isBstTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            sumTreeNodeValue(root);
            return maxValue;
        }
        maxSumBST2(root.left);
        maxSumBST2(root.right);
        return maxValue;
    }

    /**
     * 判断是否是bstTree
     * @param root
     * @param min
     * @param max
     * @return
     */
    public boolean isBstTree(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        return root.val > min && root.val < max && isBstTree(root.left, min, root.val) && isBstTree(root.right, root.val, max);
    }

    /**
     * 求二叉搜索树某节点下所有节点的和
     * @param root
     * @return
     */
    public int sumTreeNodeValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int temp = root.val + sumTreeNodeValue(root.left) + sumTreeNodeValue(root.right);
        maxValue = Math.max(maxValue, temp);
        return temp;
    }
}