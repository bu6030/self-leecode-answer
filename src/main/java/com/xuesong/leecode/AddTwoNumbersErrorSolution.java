package com.xuesong.leecode;

public class AddTwoNumbersErrorSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long l1Sum = sum(l1);
        long l2Sum = sum(l2);
        long totalSum = l1Sum + l2Sum;
        return split(totalSum);
    }

    public long sum(ListNode l1) {
        long l1Num = 0;
        long size = 1;
        if (l1 != null) {
            l1Num += l1.val * size;
            size = size * 10;
        } else {
            return 0;
        }
        while (l1.next != null) {
            l1 = l1.next;
            l1Num += l1.val * size;
            size = size * 10;
        }
        return l1Num;
    }

    public ListNode split(long sum) {
        ListNode headNode = null;
        if (sum == 0) {
            return new ListNode(0);
        }
        long length = 1;
        while (sum / length >= 10) {
            length = length * 10;
        }

        while (length > 0) {
            if (headNode == null) {
                long nodeVal = sum / length;
                headNode = new ListNode((int) nodeVal);
                sum = sum - headNode.val * length;
                length = length / 10;
            } else {
                if (length == 10 || length == 1) {
                    System.out.println("111");
                }
                long nodeVal = sum / length;
                headNode = new ListNode((int) nodeVal, headNode);
                sum = sum - headNode.val * length;
                length = length / 10;
            }
        }
        return headNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        // ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        // ListNode l1 = new ListNode(0);
        // ListNode l2 = new ListNode(0);
        // ListNode l1 = new ListNode(5,new ListNode(6));
        // ListNode l2 = new ListNode(5,new ListNode(4,new ListNode(9)));
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9,
            new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        AddTwoNumbersErrorSolution addTwoNumbersSolution = new AddTwoNumbersErrorSolution();
        addTwoNumbersSolution.addTwoNumbers(l1, l2);
    }
}
