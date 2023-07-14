package com.xuesong.java.java10.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  JAVA10 新增 var 关键字，只能用于局部变量，不能用于方法的参数、方法返回值、类的字段等。
 */
public class VarTest {
    public static void main(String[] args) {
        System.out.println("=======");
        var number = 10;
        var pi = 3.14;
        System.out.println("number:" + number +";pi=" + pi);
        System.out.println("=======");
        var message = "Hello, World!";
        var list = new ArrayList<String>();
        list.add("123");
        list.add("234");
        System.out.println("message:" + message);
        list.forEach(System.out::println);
        System.out.println("=======");
        var numbers = List.of(1, 2, 3, 4, 5);
        var map = new HashMap<Integer, String>();
        map.put(123, "123");
        numbers.forEach(System.out::println);
        map.forEach((key, value) -> System.out.println(map.get(key)));
    }
}
