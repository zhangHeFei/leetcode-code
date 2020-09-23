package com.leetcode.algorithm;

import java.util.List;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode current = null;
        if (compare(l1, l2) > 0){
            current = l2;
            l2 = l2.next;
        }else {
            current = l1;
            l1 = l1.next;
        }
        ListNode head = current;

        while (l1 != null || l2 != null){
            if (l1 == null) {
                current.next = l2;
                l2 = l2.next;
            }else if (l2 == null){
                current.next = l1;
                l1 = l1.next;
            }else{
                if (compare(l1, l2) > 0){
                    current.next = l2;
                    l2 = l2.next;
                }else {
                    current.next = l1;
                    l1 = l1.next;
                }
            }
            current = current.next;
        }

        return head;

    }

    private int compare(ListNode l1, ListNode l2){

        if (l1.val == l2.val){
            return 0;
        }

        return l1.val > l2.val ? 1 : -1;
    }
}
