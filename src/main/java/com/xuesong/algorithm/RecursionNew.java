package com.xuesong.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 递推算法
 * 斐波那契额数列
 */
public class RecursionNew {
    // 初始化list，初始状态，总共1个兔子
    // 1月底，总共1个兔子
    static List<Integer> list = new ArrayList<>();
    static {
        // 放入0只，为了设置月数第1月底为1，这个只为了填充list的0
        list.add(0);
        // 初始值，1
        list.add(1);
        // 1月底，1
        list.add(2);
    }
    public static int fibonacci (int month) {
        // 获取初始状态和1月底，都直接返回兔子总数
        if(month <= 2){
            return list.get(month);
        }
        // 循环递推计算第month月底，总共多少只兔子
        for(int i=3; i <= month; i++){
            int rabbitCount = list.get(i-2) + list.get(i-1);
            list.add(rabbitCount);
        }
        // 返回第month月底，总共多少只兔子
        return list.get(month);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }
}
