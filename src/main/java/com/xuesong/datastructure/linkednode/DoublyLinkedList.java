package com.xuesong.datastructure.linkednode;

public class DoublyLinkedList {
    private DoublyLinkedNode head;

    public void add(String value){
        if (head == null) {
            head  = new DoublyLinkedNode(value);
        } else {
            DoublyLinkedNode next = head.getNext();
            DoublyLinkedNode pre = null;
            if(next==null){
                DoublyLinkedNode newNode = new DoublyLinkedNode(value);
                newNode.setPre(head);
                head.setNext(newNode);
                return;
            }
            while(next!=null) {
                pre = next;
                next = next.getNext();
            }
            DoublyLinkedNode newNode = new DoublyLinkedNode(value);
            newNode.setPre(pre);
            pre.setNext(newNode);
        }
    }
    public DoublyLinkedNode search(String value) throws Exception{
        if (head == null) {
            throw new Exception();
        } else {
            if (head.getValue() == value) {
                return head;
            } else {
                DoublyLinkedNode next = head.getNext();
                while(next!=null){
                    if(value==next.getValue()){
                        return next;
                    }
                    next = next.getNext();
                }
                return null;
            }
        }
    }

    public void remove(String value) throws Exception{
        if (head == null) {
            throw new Exception();
        } else {
            if (head.getValue() == value) {
                DoublyLinkedNode next = head.getNext();
                next.setPre(null);
                head = next;
            } else {
                DoublyLinkedNode pre = head;
                DoublyLinkedNode next = head.getNext();
                while(next!=null&&next.getValue()!=value){
                    pre = next;
                    next = next.getNext();
                }
                //找到了
                if(next!=null && value==next.value){
                    DoublyLinkedNode newNext = next.getNext();
                    pre.setNext(newNext);
                    if(newNext!=null) {
                        newNext.setPre(pre);
                    }
                    next.setNext(null);
                    next.setPre(null);
                }
            }
        }
    }

    public void set(String value, String newValue) throws Exception{
        if (head == null) {
            throw new Exception();
        } else {
            if (head.getValue() == value) {
                DoublyLinkedNode newHead = new DoublyLinkedNode(newValue);
                newHead.setNext(head.getNext());
                head.next = null;
                head = newHead;
            } else {
                DoublyLinkedNode pre = head;
                DoublyLinkedNode next = head.getNext();
                while(next!=null){
                    if(value==next.getValue()){
                        DoublyLinkedNode newNode = new DoublyLinkedNode(newValue);
                        newNode.setNext(next.getNext());
                        newNode.setPre(next.getPre());
                        pre.setNext(newNode);
                        if(next.getNext()!=null) {
                            next.getNext().setPre(newNode);
                        }
                        next.setPre(null);
                        next.setNext(null);
                        break;
                    }
                    pre = next;
                    next = next.getNext();
                }
            }
        }
    }

    public static void main(String[] args)  throws Exception{
        DoublyLinkedList link = new DoublyLinkedList();
        link.add("a");
        link.add("b");
        link.add("c");
        link.add("d");
        link.add("e");
        System.out.println(link);
        System.out.println(link.search("c"));
        link.remove("e");
        System.out.println(link);
        link.set("d","f");
        System.out.println(link);
    }

    public static class DoublyLinkedNode {
        public DoublyLinkedNode(String value) {
            this.value = value;
        }
        private DoublyLinkedNode pre;
        private DoublyLinkedNode next;
        private String value;

        public DoublyLinkedNode getPre() {
            return pre;
        }

        public void setPre(DoublyLinkedNode pre) {
            this.pre = pre;
        }

        public DoublyLinkedNode getNext() {
            return next;
        }

        public void setNext(DoublyLinkedNode next) {
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "DoublyLinkedNode{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        String output = "";
        DoublyLinkedNode cur = head;
        while(cur != null){
            output += "["+cur+"],";
            cur = cur.getNext();
        }
        return "DoublyLinkedList{"
                + output +
                '}';
    }
}
