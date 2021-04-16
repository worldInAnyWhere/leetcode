package com.mark.leetcode.answer.page3;

import com.mark.leetcode.answer.base.ListNode;

/**
 * 对链表进行插入排序
 * ListNode节点的题目总是搞不清楚,这个也费了不少时间，要加强这块
 */
class Solution147 {
    public static void main(String[] args) {
        int[] param = new int[]{4, 2, 1, 3};
        ListNode start = ListNode.changeArrayToListNode(param);
        Solution147 solution147 = new Solution147();
        System.out.println(solution147.insertionSortList(start));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode last = head;
        ListNode now = null;
        ListNode first = new ListNode();
        first.next = head;
        while ((now = last.next) != null) {
            if (now.val >= last.val) {
                last = last.next;
            } else {
                ListNode pre = first;
                while (pre.next.val < now.val) {
                    pre = pre.next;
                }
                last.next = now.next;
                now.next = pre.next;
                pre.next = now;
            }

        }
        return first.next;
    }
}