package com.xuesong.datastructure.queue;

/**
 * 先进先出普通队列
 * 通过单链表实现，队列内元素个数不需要初始化，队列内元素个数可以放入很多
 */
public class NormalQueue<E> {
    private SinglyLinkedNode first;
    private SinglyLinkedNode last;

    /**
     * 通过单链表即可实现
     * 
     * @param <E>
     */
    public static class SinglyLinkedNode<E> {
        public SinglyLinkedNode(E value) {
            this.value = value;
        }

        private E value;
        private SinglyLinkedNode next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "SinglyLinkedNode{" +
                "value=" + value +
                '}';
        }
    }

    /**
     * 从队尾插入新节点
     * 
     * @param e
     */
    public void push(E e) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(e);
        if (first == null) {
            first = newNode;
        }
        if (last == null) {
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * 从队首取出节点
     */
    public E pop() {
        if (first == null) {
            return null;
        }
        SinglyLinkedNode<E> node = first;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return node.getValue();
    }

    public static void main(String[] args) {
        NormalQueue<String> queue = new NormalQueue<String>();
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.push("d");
        String result = queue.pop();
        while (result != null) {
            System.out.println("pop == " + result);
            result = queue.pop();
        }
    }
}
