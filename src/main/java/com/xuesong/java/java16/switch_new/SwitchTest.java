package com.xuesong.java.java16.switch_new;

/**
 * JAVA 16 Switch表达式增强，同 instanceof 一样可以直接给变量赋值
 */
public class SwitchTest {
    public static void main(String[] args) {
        Object o = "";
        String formatted = "unknown";
        // 直接对 i 进行赋值
        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (o instanceof String s) {
            formatted = String.format("String %s", s);
        }
        System.out.println(formatted);
    }
}
