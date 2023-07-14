package com.xuesong.java.java11.string;

import java.util.stream.Collectors;

public class StringTest {

    public static void main(String[] args) {
        // isBlank() 方法：isBlank() 方法用于检查字符串是否为空或仅由空白字符组成。它返回一个布尔值，指示字符串是否为空白。
        String str1 = ""; // 空字符串
        String str2 = "   "; // 仅包含空白字符的字符串

        System.out.println(str1.isBlank()); // 输出 true
        System.out.println(str2.isBlank()); // 输出 true
        // strip() 方法：strip() 方法用于去除字符串的首尾空白字符。它返回一个新的字符串，不包含首尾的空白字符。
        String str = "  Hello, World!  ";

        String stripped = str.strip();
        System.out.println(stripped); // 输出 "Hello, World!"
        //stripLeading() 和 stripTrailing() 方法
        // stripLeading() 方法用于去除字符串开头的空白字符
        // stripTrailing() 方法用于去除字符串末尾的空白字符。
        // 它们分别返回一个新的字符串，不包含开头或末尾的空白字符。
        String str3 = "  Hello, World!  ";

        String strippedLeading = str3.stripLeading();
        System.out.println(strippedLeading); // 输出 "Hello, World!  "

        String strippedTrailing = str3.stripTrailing();
        System.out.println(strippedTrailing); // 输出 "  Hello, World!"
        // lines() 方法：lines() 方法用于将字符串拆分为行的流。它返回一个流，其中每个元素都是字符串的一行。
        String str4 = "Hello\nWorld\nJava";

        str4.lines().forEach(System.out::println);
        System.out.println(str4.lines().count());
        str4.lines().collect(Collectors.toList()).forEach(System.out::println);
        // repeat()，用于将字符串重复指定次数
        String str5 = "Hello";
        String repeated = str5.repeat(3);
        System.out.println(repeated); // 输出 "HelloHelloHello"
    }
}
