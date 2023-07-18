package com.xuesong.java.java16.record;

/**
 * JAVA16 增加record类，使用比较方便，创建出来不可变
 * 适用于那些需要创建简单、不可变的对象的场景，例如配置文件中的键值对、数据库记录等。
 * 但是如果想要在 SpringBoot 的 Controller 接口中返回 response，序列化会报错。
 */
public class RecordTest {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        System.out.println(person.name()); // 输出 "Alice"
        System.out.println(person.age()); // 输出 30
    }
}
