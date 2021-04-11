package com.mark.leetcode.answer.page11;

import com.mark.leetcode.answer.base.TreeNode;

/**
 * 把二叉搜索树转换为累加树，同1038一样，但这里的解法略有不同，没用全局变量
 */
public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        addTree(root, 0);
        return root;
    }

    public int addTree(TreeNode root, int addValue) {
        if (root == null) {
            return addValue;
        }
        //把右边的都累加进来
        int add = addTree(root.right, addValue);
        root.val = add + root.val;
        return addTree(root.left, root.val);
    }
}
