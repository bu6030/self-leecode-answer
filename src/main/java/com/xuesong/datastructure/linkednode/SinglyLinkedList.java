package com.xuesong.datastructure.linkednode;

/**
 * 单向链表
 */
public class SinglyLinkedList {

    private SinglyLinkedNode head;
    public static class SinglyLinkedNode {
        public SinglyLinkedNode (String value) {
            this.value = value;
        }
        private SinglyLinkedNode next;
        private String value;
    }

    public void add(String value){
        if (head == null) {
            head  = new SinglyLinkedNode(value);
        } else {
            SinglyLinkedNode next = head.next;
            SinglyLinkedNode last = null;
            if(next==null){
                head.next = new SinglyLinkedNode(value);
                return;
            }
            while(next!=null) {
                last = next;
                next = next.next;
            }
            last.next = new SinglyLinkedNode(value);
        }
    }

    public SinglyLinkedNode search(String value) throws Exception{
        if (head == null) {
            throw new Exception();
        } else {
            if (head.value == value) {
                return head;
            } else {
                SinglyLinkedNode next = head;
                while(next!=null){
                    if(value==next.value){
                        return next;
                    }
                    next = next.next;
                }
                return null;
            }
        }
    }

    public void remove(String value) throws Exception{
        if (head == null) {
            throw new Exception();
        } else {
            if (head.value == value) {
                head = head.next;
            } else {
                SinglyLinkedNode pre = head;
                SinglyLinkedNode next = head.next;
                while(next!=null&&next.value!=value){
                    pre = next;
                    next = next.next;
                }
                if(value==next.value){
                    pre.next = next.next;
                }
            }
        }
    }

    public void set(String value, String newValue) throws Exception{
        if (head == null) {
            throw new Exception();
        } else {
            if (head.value == value) {
                SinglyLinkedNode newHead = new SinglyLinkedNode(newValue);
                newHead.next = head.next;
                head = newHead;
            } else {
                SinglyLinkedNode pre = head;
                SinglyLinkedNode next = head.next;
                while(next!=null){
                    if(value==next.value){
                        SinglyLinkedNode newNode = new SinglyLinkedNode(newValue);
                        newNode.next = next.next;
                        pre.next = newNode;
                        break;
                    }
                    next = next.next;
                }
            }
        }
    }

    public static void main(String[] args)  throws Exception{
        SinglyLinkedList link = new SinglyLinkedList();
        link.add("a");
        link.add("b");
        link.add("c");
        System.out.println(link);
        System.out.println(link.search("c").value);
        link.remove("c");
        System.out.println(link);
        link.set("b","d");
        System.out.println(link);
    }

    @Override
    public String toString() {
        String output = "";
        SinglyLinkedNode cur = head;
        while(cur != null){
            output += "["+cur.value+"],";
            cur = cur.next;
        }
        return "SinglyLinkedList{"
                + output +
                '}';
    }
}
