package com.xuesong.java.java11.lambda;

import java.util.function.Consumer;

/**
 * Java11 开始允许开发者在 Lambda 表达式中使用 var 进行参数声明
 */
public class LambdaTest {
    public static void main(String[] args) {
        // 使用 var 类型推断的 Lambda 参数
        Consumer<String> printLength = (var s) -> {
            System.out.println("Length of " + s + ": " + s.length());
        };

        // 调用 Lambda 表达式
        printLength.accept("Hello");
        printLength.accept("Java 11");
    }
}
