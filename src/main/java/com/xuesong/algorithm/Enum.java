package com.xuesong.algorithm;

/**
 * 枚举法也称之为穷举算法
 * 水仙花算法，首先我们来了解一下什么是水仙花数，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该本身
 */
public class Enum {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int a = i / 100;
            int b = i / 10 % 10;
            int c = (i % 10);
            if ((Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)) == i) {
                System.out.println("水仙花:" + i);
            }
        }
    }
}
