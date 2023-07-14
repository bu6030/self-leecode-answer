package com.xuesong.java10.collection_copy_of;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JAVA10 集合新增 copyOf 方法
 */
public class CopyOfTest {

    public static void main(String[] args) {
        // 通过 of 方法创建结合，均不可修改，后边均会报错
        List<String> list = List.of("apple", "banana", "orange");
        Set<Integer> set = Set.of(1, 2, 3, 4);
        Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);
        try {
            list.add("123");
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            set.add(5);
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            map.put("four", 4);
        } catch (Exception e){
            e.printStackTrace();
        }
        // copyOf方法，用于创建一个不可变集合的副本
        List<String> originalList = new ArrayList<>();
        originalList.add("apple");
        originalList.add("banana");
        originalList.add("orange");

        List<String> copyList = List.copyOf(originalList);

        // forEach方法的增强
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.parallelStream().forEach(System.out::println);
    }
}
