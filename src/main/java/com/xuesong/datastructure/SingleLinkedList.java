package com.xuesong.datastructure;

/**
 * 单链表
 */
public class SingleLinkedList {

    private SingleLinkedNode head;
    public static class SingleLinkedNode {
        public SingleLinkedNode (String value) {
            this.value = value;
        }
        private SingleLinkedNode next;
        private String value;
    }

    public void add(String value){
        if (head == null) {
            head  = new SingleLinkedNode(value);
        } else {
            SingleLinkedNode next = head.next;
            SingleLinkedNode last = null;
            if(next==null){
                head.next = new SingleLinkedNode(value);
                return;
            }
            while(next!=null) {
                last = next;
                next = next.next;
            }
            last.next = new SingleLinkedNode(value);
        }
    }

    public SingleLinkedNode search(String value) throws Exception{
        if (head == null) {
            throw new Exception();
        } else {
            if (head.value == value) {
                return head;
            } else {
                SingleLinkedNode next = head;
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
                SingleLinkedNode pre = head;
                SingleLinkedNode next = head.next;
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
                SingleLinkedNode newHead = new SingleLinkedNode(newValue);
                newHead.next = head.next;
                head = newHead;
            } else {
                SingleLinkedNode pre = head;
                SingleLinkedNode next = head.next;
                while(next!=null){
                    if(value==next.value){
                        SingleLinkedNode newNode = new SingleLinkedNode(newValue);
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
        SingleLinkedList link = new SingleLinkedList();
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
        SingleLinkedNode cur = head;
        while(cur != null){
            output += "["+cur.value+"],";
            cur = cur.next;
        }
        return "SingleLinkedList{"
                + output +
                '}';
    }
}
