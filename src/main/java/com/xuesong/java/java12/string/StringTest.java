package com.xuesong.java.java12.string;

import java.util.Optional;

public class StringTest {
    public static void main(String[] args) {
        // String.indent(int n)：该方法用于对字符串进行缩进。
        // 它接受一个整数参数 n，表示缩进的级别。正值表示向右缩进，负值表示向左缩进。
        String text1 = "Hello\nWorld";
        String indentedText = text1.indent(4);
        System.out.println(indentedText);
        String text2 = "    Hello\n    World";
        System.out.println(text2);
        String indentedText2 = text2.indent(-4);
        System.out.println(indentedText2);

        // String.transform(Function<? super CharSequence, ? extends R> f)：该方法用于对字符串进行转换。
        // 它接受一个函数参数 f，该函数将输入的 CharSequence（字符串）转换为类型 R。
        // 实际上就是可以传入一个Function作为参数，对 String 的操作可以各种动态变化
        String text3 = "Hello, Java 12";
        String transformedText = text3.transform(s -> s.replace("Java", "Java SE"));
        System.out.println(transformedText);
    }
}
