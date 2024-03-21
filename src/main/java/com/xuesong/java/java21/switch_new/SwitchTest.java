package com.xuesong.java.java21.switch_new;

/**
 * JAVA21 Switch 方法增强
 */
public class SwitchTest {

    /**
     * break优化
     * yield返回优化
     * 多行数据匹配优化
     * null优化
     * @param day
     */
    public static void switchTest(String day) {
        String i = switch (day) {
            // 不用再写 break
            case "MONDAY" -> {
                System.out.println("又要上班了...");
                // 可以在多行代码块钟使用 yield 返回结果
                yield "星期1";
            }
            case "TUESDAY" -> "星期2";
            case "WEDNESDAY" -> "星期3";
            case "THURSDAY" -> "星期4";
            case "FRIDAY" -> "星期5";
            // 多行数据的匹配，通过逗号分割
            case "SATURDAY","SUNDAY" ->  "周末";
            // 支持null了，JAVA21 之前会报异常
            case null -> "这是null";
            default -> "未知";
        };
        System.out.println(i);
    }

    /**
     * 不同类型参数请求优化，实际内部使用了instanceof优化
     * @param obj
     */
    public static void switchTestNew(Object obj) {
        String result = switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> obj.toString();
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        // 测试yeild返回
        String day = "MONDAY";
        switchTest(day);
        // 测试多行数据匹配
        day = "SUNDAY";
        switchTest(day);
        // 测试null
        day = null;
        switchTest(day);
        // 测试数据格式化
        day = "123213";
        switchTestNew(day);
        int number = 123;
        switchTestNew(number);
    }
}