package com.mark.leetcode.answer.page3;

import com.mark.leetcode.answer.base.ListNode;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.StructureLoader;

/**
 * 排序链表
 * 对于ListNode这类题目还是有困难，做的不好，要加强。这种题目尤其考验引用的使用。
 */
class Solution148 {

    public static void main(String[] args) {
        int[] param = new int[]{4, 2, 1, 3};
        ListNode start = ListNode.changeArrayToListNode(param);
        Solution148 solution148 = new Solution148();
        System.out.println(solution148.sortList(start));
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode quik = head;
        while (quik != tail) {
            slow = slow.next;
            quik = quik.next;
            if (quik != tail) {
                quik = quik.next;
            }
        }
        ListNode mid = slow;
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode first = new ListNode();
        ListNode temp = first;
        ListNode left = head1, right = head2;
        while (right != null && left != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left == null) {
            temp.next = right;
        } else if (right == null) {
            temp.next = left;
        }
        return first.next;
    }
}