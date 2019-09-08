package xieCheng;

import java.util.Scanner;

public class Main2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);

        ListNode curBig = big;
        ListNode curSmall = small;

        ListNode p = head;
        while (p != null) {
            if (p.val <= m) {
                curSmall.next = p;
                curSmall = curSmall.next;
            } else {
                curBig.next = p;
                curBig = curBig.next;
            }
            p = p.next;
        }

        curSmall.next = big.next;
        curBig.next = null;
        return small.next;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
