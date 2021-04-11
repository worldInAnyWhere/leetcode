package com.mark.leetcode.answer.page21;

import com.mark.leetcode.answer.base.TreeNode;

/**
 * 把二叉搜索树转换为累加树,同538一样，但这里的解法略有不同
 */
class Solution1038 {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}