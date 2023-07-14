package com.xuesong.java.java11.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional op = Optional.empty();
        System.out.println(op.isEmpty());//判断指定的 Optional 对象是否为空
    }
}
