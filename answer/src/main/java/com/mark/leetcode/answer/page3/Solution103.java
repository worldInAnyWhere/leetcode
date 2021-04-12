package com.mark.leetcode.answer.page3;

import com.mark.leetcode.answer.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的齿形层序遍历
 */
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            boolean leftToRight = true;
            stack.add(root);
            while (stack.size() > 0) {
                result.add(zigzagLevel(stack, leftToRight));
                leftToRight = !leftToRight;
            }
        }
        return result;
    }

    public List<Integer> zigzagLevel(LinkedList<TreeNode> stack, boolean leftToRight) {
        List<Integer> result = new ArrayList<Integer>();
        int length = stack.size();
        TreeNode node = null;
        for (int i = 0; i < length; i++) {
            if (leftToRight) {
                node = stack.removeFirst();
                result.add(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            } else {
                node = stack.removeLast();
                result.add(node.val);
                if (node.right != null) {
                    stack.addFirst(node.right);
                }
                if (node.left != null) {
                    stack.addFirst(node.left);
                }
            }
        }
        return result;
    }

}