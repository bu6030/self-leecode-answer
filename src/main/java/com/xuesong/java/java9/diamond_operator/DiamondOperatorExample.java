package com.xuesong.java.java9.diamond_operator;

import java.util.*;

/**
 * Java 9 中的钻石操作符支持匿名内部类，实际上可以更简洁地初始化泛型类型
 * 但是，之前已经存在 Map.of 和 List.of/Arrays.asList，再写个这个意义何在？
 */
public class DiamondOperatorExample {

    public static void main(String[] args) {
        // JDK 8 中是new HashMap<String, Integer>
        Map<String, Integer> map = new HashMap<>() {{
            put("One", 1);
            put("Two", 2);
            put("Three", 3);
        }};

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // JDK 8 中是new ArrayList<String>
        List<String> names = new ArrayList<>(){{
            add("Alice");
            add("Bob");
            add("Charlie");
        }};

        for (String name : names) {
            System.out.println(name);
        }
    }
}
