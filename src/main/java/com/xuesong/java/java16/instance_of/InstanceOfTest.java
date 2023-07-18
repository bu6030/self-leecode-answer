package com.xuesong.java.java16.instance_of;

import java.util.HashMap;
import java.util.Map;

/**
 * JAVA16 instanceof 增加，在表达式中直接赋值给变量
 */
public class InstanceOfTest {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("key1", "aaa");
        data.put("key2", 111);
        Object value = data.get("key1");
        // 老版本写法，需要在 instanceof 之后在进行赋值操作
        if (value instanceof String) {
            String s = (String) value;
            System.out.println(s.substring(1));
        }
        // JAVA16 可以直接在 instanceof 表达式中的最后写一个变量，直接赋值，写法更简单
        Object value1 =data.get("key1");
        if (value1 instanceof String aaa) {
            System.out.println(aaa.substring(1));
        }

    }
}
