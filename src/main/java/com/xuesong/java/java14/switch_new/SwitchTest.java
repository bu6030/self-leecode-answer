package com.xuesong.java.java14.switch_new;

/**
 * JAVA 14 Switch 表达式优化
 * 为 switch 表达式引入了类似 lambda 语法条件匹配成功后的执行块，不需要多写 break
 * 提供了 yield 来在 block 中返回值
 */
public class SwitchTest {
    public static void main(String[] args) {
        int day = 3;
        String dayName = switch (day) {
            case 1 -> "星期一";
            case 2 -> "星期二";
            case 3 -> "星期三";
            case 4 -> "星期四";
            case 5 -> "星期五";
            default -> "未知";
        };
        System.out.println(dayName); // 输出："星期三"

        String value = "";
        String result = switch (value) {
            case "A", "B", "C" -> "ABC";
            case "D", "E", "F" -> "DEF";
            default -> {
                if (value.isEmpty())
                    yield "请输入有效的值。";
                else
                    yield "看起来是一个不错的值。";
            }
        };
        System.out.println(result);
    }
}
