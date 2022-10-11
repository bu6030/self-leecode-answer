package com.xuesong.datastructure.queue;

/**
 * 先进先出普通队列
 * 通过数组实现，队列内的元素个数需要初始化，有限制
 */
public class NoramlArrayQueue {
    private Object[] arr;
    private int maxSize = -1;
    private int curIndex = -1;

    public NoramlArrayQueue(int size) {
        arr = new Object[size];
        maxSize = size;
    }

    /**
     * 从队尾插入新节点
     * 
     * @param
     */
    public void push(Object e) throws Exception {
        if (curIndex >= maxSize - 1) {
            throw new Exception("Queue if full");
        }
        arr[++curIndex] = e;
    }

    public Object pop() throws Exception {
        if (curIndex == -1) {
            return null;
        }
        return arr[curIndex--];
    }

    public static void main(String[] args) throws Exception {
        NoramlArrayQueue queue = new NoramlArrayQueue(10);
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.push("d");
        queue.push("e");
        queue.push("f");
        queue.push("g");
        queue.push("h");
        queue.push("i");
        queue.push("j");
        // 到达这个放入k就会报满了的异常
        // queue.push("k");
        String result = (String) queue.pop();
        while (result != null) {
            System.out.println("pop == " + result);
            result = (String) queue.pop();
        }
        // 由于之前已经清空了，重复放入新值即可
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.push("4");
        queue.push("5");
        queue.push("6");
        queue.push("7");
        queue.push("8");
        queue.push("9");
        result = (String) queue.pop();
        while (result != null) {
            System.out.println("pop == " + result);
            result = (String) queue.pop();
        }
    }
}
