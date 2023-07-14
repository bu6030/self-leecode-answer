package com.xuesong.java.java11.optional;

import java.util.Optional;
/**
 * Java 11 Optional 增强
 * 新增了empty()方法来判断指定的 Optional 对象是否为空
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isEmpty());//判断指定的 Optional 对象是否为空
    }
}
