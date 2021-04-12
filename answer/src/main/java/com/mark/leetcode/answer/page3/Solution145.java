package com.mark.leetcode.answer.page3;

import com.mark.leetcode.answer.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 */
class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List result = new ArrayList();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List result) {
        if (root != null) {
            preorderTraversal(root.left, result);
            preorderTraversal(root.right, result);
            result.add(root.val);
        }
    }
}