package com.xuesong.leecode;

public class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Val = 0;
        int l2Val = 0;
        int outSum = 0;
        ListNode headNode = null;
        ListNode newNode = null;
        ListNode lastNode = null;
        int sum = 0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                l1Val = l1.val;
                l1 = l1.next;
            }else{
                l1Val = 0;
            }
            if(l2!=null){
                l2Val = l2.val;
                l2 = l2.next;
            }else{
                l2Val = 0;
            }
            sum = l1Val +l2Val+outSum;
            outSum = 0;
            if(sum>=10){
                newNode = new ListNode(sum%10);
                outSum = 1;
                if(lastNode==null){
                    lastNode = newNode;
                }else {
                    lastNode.next = newNode;
                    lastNode = newNode;
                }
                if(headNode==null){
                    headNode = newNode;
                }
            }else{
                newNode = new ListNode(sum);
                if(lastNode==null) {
                    lastNode = newNode;
                }else {
                    lastNode.next = newNode;
                    lastNode = newNode;
                }
                if(headNode==null){
                    headNode = newNode;
                }
            }
        }
        if(outSum>0){
            newNode = new ListNode(outSum);
            if(lastNode==null) {
                lastNode = newNode;
            }else {
                lastNode.next = newNode;
                lastNode = newNode;
            }
            if(headNode==null){
                headNode = newNode;
            }
        }
        return headNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(0);
//        ListNode l1 = new ListNode(5,new ListNode(6));
//        ListNode l2 = new ListNode(5,new ListNode(4,new ListNode(9)));
//ListNode l1 = new ListNode(9);
//ListNode l2 = new ListNode(1, new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9))))))))));
        ListNode l1 = new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9))));
        ListNode l2 = new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9)))))));
        AddTwoNumbersSolution addTwoNumbersSolution = new AddTwoNumbersSolution();
        addTwoNumbersSolution.addTwoNumbers(l1,l2);
    }
}
