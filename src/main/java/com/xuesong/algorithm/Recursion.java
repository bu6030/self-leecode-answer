package com.xuesong.algorithm;

/**
 * 递归算法
 * 斐波那契额数列
 */
public class Recursion {
    public static int fibonacci (int i) {
        // 初始值，总共1个兔子
        if(i == 0){
            return 1;
            // 1月底，总共1个兔子
        } else if(i == 1){
            return 1;
        }
        // 递归调用本方法，并把前两次的累加起来，获取i月底兔子总数
        return fibonacci(i-1) + fibonacci(i-2);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }
}
