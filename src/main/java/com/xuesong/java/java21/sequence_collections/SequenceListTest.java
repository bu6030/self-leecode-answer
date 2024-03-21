package com.xuesong.java.java21.sequence_collections;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * JAVA21 一些集合继承了 SequencedCollection、SequencedSet和SequencedMap
 * SequencedCollection 新增了 addFirst，addLast，removeFirst，removeLast，reversed 方法
 * SequencedSet 新增了 reversed 方法，同时 SequencedSet 继承了 SequencedCollection addFirst，addLast，removeFirst，removeLast，reversed 方法
 * SequencedMap 新增了 putFirst，putLast，firstEntry，lastEntry，pollFirstEntry，pollLastEntry，reversed，sequencedKeySet，sequencedValues，sequencedEntrySet 方法
 */
public class SequenceListTest {

    public static void main(String[] args) {
        // List/Deque 继承了 SequencedCollection
        System.out.println("=======list======");
        // ArrayList 实现了 List
        List<String> list = new ArrayList<>();
        list.add("456");
        list.add("123");
        list.add("def");
        list.add("abc");
        list.forEach(System.out::println);
        System.out.println("=======list======");
        list.addFirst("first");
        list.addLast("last");
        list.forEach(System.out::println);
        System.out.println("======list=======");
        list.removeFirst();
        list.removeLast();
        list.forEach(System.out::println);
        System.out.println("=======list======");
        list.reversed().forEach(System.out::println);

        System.out.println("======deque=======");
        // ArrayDeque 实现了 Deque
        Deque<String> deque = new ArrayDeque<>();
        deque.add("456");
        deque.add("123");
        deque.add("def");
        deque.add("abc");
        deque.forEach(System.out::println);
        System.out.println("=====deque========");
        deque.addFirst("first");
        deque.addLast("last");
        deque.forEach(System.out::println);
        System.out.println("=======deque======");
        deque.removeFirst();
        deque.removeLast();
        deque.forEach(System.out::println);
        System.out.println("=======deque======");
        deque.reversed().forEach(System.out::println);

        System.out.println("======linkedHashSet=======");
        // LinkedHashSet 实现了 SequencedSet 接口。
        // SequencedSet 继承了 SequencedCollection，因此也有如下几个方法
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("456");
        linkedHashSet.add("123");
        linkedHashSet.add("def");
        linkedHashSet.add("abc");
        linkedHashSet.forEach(System.out::println);
        System.out.println("=======linkedHashSet======");
        linkedHashSet.addFirst("first");
        linkedHashSet.addLast("last");
        linkedHashSet.forEach(System.out::println);
        System.out.println("======linkedHashSet=======");
        linkedHashSet.removeFirst();
        linkedHashSet.removeLast();
        linkedHashSet.forEach(System.out::println);
        System.out.println("=======linkedHashSet======");
        // 注意下面这个 reversed 方法是 SequencedSet 而不是 SequencedCollection 的方法
        linkedHashSet.reversed().forEach(System.out::println);

        System.out.println("=======SortedSet======");
        // SortedSet 继承了 SequencedSet。
        // SequencedSet 继承了 SequencedCollection，因此也有如下几个方法
        SortedSet sortedSet = new ConcurrentSkipListSet();
        sortedSet.add("456");
        sortedSet.add("123");
        sortedSet.add("def");
        sortedSet.add("abc");
        sortedSet.forEach(System.out::println);
        System.out.println("=======SortedSet======");
        // 注意下面方法执行会报错，因为 SortedSet 是排序的，不支持向指定位置插入
//        sortedSet.addFirst("first");
//        sortedSet.addLast("last");
//        sortedSet.forEach(System.out::println);
        System.out.println("======SortedSet=======");
        sortedSet.removeFirst();
        sortedSet.removeLast();
        sortedSet.forEach(System.out::println);
        System.out.println("=======SortedSet======");
        // 注意下面这个 reversed 方法是 SequencedSet 而不是 SequencedCollection 的方法
        sortedSet.reversed().forEach(System.out::println);

        System.out.println("=======SortedMap======");
        // SortedMap 继承了 SequencedMap。
        SortedMap sortedMap = new TreeMap();
        sortedMap.put("456", "456value");
        sortedMap.put("123", "123value");
        sortedMap.put("def", "defvalue");
        sortedMap.put("abc", "abcvalue");
        sortedMap.forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));
        System.out.println("=======SortedMap======");
        // 注意下面方法执行会报错，因为 TreeMap 是排序的，不支持向指定位置插入
//        sortedMap.putFirst("first", "firstvalue");
//        sortedMap.putLast("last", "lastvalue");
//        sortedMap.forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));
        System.out.println("=======SortedMap======");
        System.out.println("firstEntry = " + sortedMap.firstEntry());
        System.out.println("lastEntry = " + sortedMap.lastEntry());
        System.out.println("pollFirstEntry = " + sortedMap.pollFirstEntry());
        System.out.println("pollLastEntry = " + sortedMap.pollLastEntry());
        System.out.println("=======SortedMap======");
        sortedMap.forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));
        System.out.println("=======SortedMap======");
        System.out.println("sequencedKeySet = " + sortedMap.sequencedKeySet());
        System.out.println("sequencedValues = " + sortedMap.sequencedValues());
        System.out.println("sequencedEntrySet = " + sortedMap.sequencedEntrySet());
        System.out.println("=======SortedMap======");
        sortedMap.reversed().forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));

        System.out.println("=======LinkedHashMap======");
        // LinkedHashMap 实现了 SequencedMap 接口。
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("456", "456value");
        linkedHashMap.put("123", "123value");
        linkedHashMap.put("def", "defvalue");
        linkedHashMap.put("abc", "abcvalue");
        linkedHashMap.forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));
        System.out.println("=======LinkedHashMap======");
        // 注意下面方法执行会报错，因为 TreeMap 是排序的，不支持向指定位置插入
        linkedHashMap.putFirst("first", "firstvalue");
        linkedHashMap.putLast("last", "lastvalue");
        linkedHashMap.forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));
        System.out.println("=======LinkedHashMap======");
        System.out.println("firstEntry = " + linkedHashMap.firstEntry());
        System.out.println("lastEntry = " + linkedHashMap.lastEntry());
        System.out.println("pollFirstEntry = " + linkedHashMap.pollFirstEntry());
        System.out.println("pollLastEntry = " + linkedHashMap.pollLastEntry());
        System.out.println("=======LinkedHashMap======");
        linkedHashMap.forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));
        System.out.println("=======LinkedHashMap======");
        System.out.println("sequencedKeySet = " + linkedHashMap.sequencedKeySet());
        System.out.println("sequencedValues = " + linkedHashMap.sequencedValues());
        System.out.println("sequencedEntrySet = " + linkedHashMap.sequencedEntrySet());
        System.out.println("=======LinkedHashMap======");
        linkedHashMap.reversed().forEach((key, value)-> System.out.println("key:" + key + ",value:" + value));
    }
}
