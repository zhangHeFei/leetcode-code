package com.leetcode.algorithm;

public class DeleteNode {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val){
            ListNode result = head.next;
            head.next = null;
            return result;
        }
        ListNode node = head;
        while (node.next != null){
            if (node.next.val == val){
                ListNode temp = node.next.next;
                node.next.next = null;
                node.next = temp;
                break;
            }
            node = node.next;
        }
        return head;
    }
}
