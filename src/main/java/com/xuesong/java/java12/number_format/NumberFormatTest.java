package com.xuesong.java.java12.number_format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * JAVA 12 NumberFormat 类引入了一些新的方法来格式化数字。
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        double number = 12345123.6789;
        // 创建一个本地化的 NumberFormat 对象
        NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(Locale.CHINESE, NumberFormat.Style.SHORT);
        // 格式化数字
        String formattedNumber = numberFormat.format(number);
        System.out.println("Formatted number: " + formattedNumber);

        NumberFormat numberFormat1 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        // 格式化数字
        String formattedNumber1 = numberFormat1.format(number);
        System.out.println("Formatted number1: " + formattedNumber1);

        NumberFormat numberFormat2 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        // 格式化数字
        String formattedNumber2 = numberFormat2.format(number);
        System.out.println("Formatted number2: " + formattedNumber2);
    }
}
