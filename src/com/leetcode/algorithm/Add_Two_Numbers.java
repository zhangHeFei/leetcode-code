package com.leetcode.algorithm;

public class Add_Two_Numbers {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //carry:记录num1+num2相加之后的进位
        int num1, num2, carry = 0, sum;
        //头指针
        ListNode headNode = new ListNode(0);
        ListNode beforeNode = new ListNode(0);
        //记录是否是第一次进入循环
        boolean flag = true;
        while (l1 != null || l2 != null){
            num1 = (l1 != null) ? l1.val : 0;
            num2 = (l2 != null) ? l2.val : 0;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            sum = num1 + num2 + carry;
            carry = sum / 10;
            ListNode afterNode = new ListNode(sum % 10);
            if (flag){
                headNode = beforeNode = afterNode;
                flag = false;
            }else{
                beforeNode.next = afterNode;
                beforeNode = beforeNode.next;
            }
        }
        if (carry == 1) beforeNode.next = new ListNode(1);
        return headNode;
    }

    public static void main(String[] args){
        Add_Two_Numbers test = new Add_Two_Numbers();
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode res = test.addTwoNumbers(l1,l2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
