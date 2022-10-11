package com.xuesong.datastructure.linkednode;

/**
 * 单向链表
 */
public class SinglyLinkedList {

    private SinglyLinkedNode head;

    public static class SinglyLinkedNode {
        public SinglyLinkedNode(String value) {
            this.value = value;
        }

        private SinglyLinkedNode next;
        private String value;

        public SinglyLinkedNode getNext() {
            return next;
        }

        public void setNext(SinglyLinkedNode next) {
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
            return "SinglyLinkedNode{" +
                "value='" + value + '\'' +
                '}';
        }
    }

    public void add(String value) {
        if (head == null) {
            head = new SinglyLinkedNode(value);
        } else {
            SinglyLinkedNode next = head.getNext();
            SinglyLinkedNode pre = null;
            if (next == null) {
                head.setNext(new SinglyLinkedNode(value));
                return;
            }
            while (next != null) {
                pre = next;
                next = next.getNext();
            }
            pre.setNext(new SinglyLinkedNode(value));
        }
    }

    public SinglyLinkedNode search(String value) throws Exception {
        if (head == null) {
            throw new Exception();
        } else {
            if (head.getValue() == value) {
                return head;
            } else {
                SinglyLinkedNode next = head.getNext();
                while (next != null) {
                    if (value == next.getValue()) {
                        return next;
                    }
                    next = next.getNext();
                }
                return null;
            }
        }
    }

    public void remove(String value) throws Exception {
        if (head == null) {
            throw new Exception();
        } else {
            if (head.getValue() == value) {
                head = head.getNext();
            } else {
                SinglyLinkedNode pre = head;
                SinglyLinkedNode next = head.getNext();
                while (next != null && next.getValue() != value) {
                    pre = next;
                    next = next.getNext();
                }
                // 找到了
                if (next != null && value == next.value) {
                    pre.setNext(next.getNext());
                }
            }
        }
    }

    public void set(String value, String newValue) throws Exception {
        if (head == null) {
            throw new Exception();
        } else {
            if (head.getValue() == value) {
                SinglyLinkedNode newHead = new SinglyLinkedNode(newValue);
                newHead.setNext(head.getNext());
                head = newHead;
            } else {
                SinglyLinkedNode pre = head;
                SinglyLinkedNode next = head.getNext();
                while (next != null) {
                    if (value == next.getValue()) {
                        SinglyLinkedNode newNode = new SinglyLinkedNode(newValue);
                        newNode.setNext(next.getNext());
                        pre.setNext(newNode);
                        break;
                    }
                    next = next.getNext();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SinglyLinkedList link = new SinglyLinkedList();
        link.add("a");
        link.add("b");
        link.add("c");
        System.out.println(link);
        System.out.println(link.search("b"));
        System.out.println(link.search("d"));
        link.remove("b");
        System.out.println(link);
        link.set("c", "d");
        System.out.println(link);
    }

    @Override
    public String toString() {
        String output = "";
        SinglyLinkedNode cur = head;
        while (cur != null) {
            output += "[" + cur + "],";
            cur = cur.getNext();
        }
        return "SinglyLinkedList{"
            + output +
            '}';
    }
}
