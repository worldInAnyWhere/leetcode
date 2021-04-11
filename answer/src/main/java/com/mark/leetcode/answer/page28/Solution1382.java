package com.mark.leetcode.answer.page28;

import com.mark.leetcode.answer.base.TreeNode;

import java.util.ArrayList;

/**
 * 将二叉搜索树变平衡
 */
class Solution1382 {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sortedList = new ArrayList();
        //第一步排序
        inorder(root, sortedList);
        //第二部直接构造一个平很二叉树
        return putInTree(sortedList, 0, sortedList.size() - 1);
    }

    public void inorder(TreeNode root, ArrayList<Integer> sortedList) {
        if (root != null) {
            inorder(root.left, sortedList);
            sortedList.add(root.val);
            inorder(root.right, sortedList);
        }
    }

    public TreeNode putInTree(ArrayList<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }
        //右移一位，相当于除以2
        int mid = start + end >> 1;
        //取start end的中间值，作为root
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = putInTree(sortedList, start, mid - 1);
        root.right = putInTree(sortedList, mid + 1, end);
        return root;
    }
}
