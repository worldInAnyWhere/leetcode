package com.mark.leetcode.answer.page3;

import com.mark.leetcode.answer.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 先序遍历
 */
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List result = new ArrayList();
        preorderTraversal(root,result);
        return result;
    }
    public void preorderTraversal(TreeNode root, List result){
        if(root!=null){
            result.add(root.val);
            preorderTraversal(root.left,result);
            preorderTraversal(root.right,result);
        }
    }
}