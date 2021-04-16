package com.mark.leetcode.answer.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        if (next != null) {
            return val + "-" + next;
        } else {
            return String.valueOf(val);
        }
    }

    public static ListNode changeArrayToListNode(int[] param) {
        ListNode first = new ListNode();
        ListNode temp = first;
        for (int p : param) {
            temp.next = new ListNode(p);
            temp = temp.next;
        }
        return first.next;
    }
}
