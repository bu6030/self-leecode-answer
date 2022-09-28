package com.xuesong.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按任何顺序返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class BackTracking {
    private static List<String> list = new ArrayList<>();
    private static String countArr = "";

    public static void main(String[] args) {
        int n = 100;
        backtracking(1, n, 3);
        // 输出打印
        list.forEach(System.out::println);
    }

    private static void backtracking(int start, int n, int toGetCnt) {
        // 终止条件
        if (toGetCnt == 0) {
            return;
        }
        // 本次集合中的元素
        for (int j = start; j <= n; j++) {
            // 处理节点
            String toAddStr = " " + j;
            countArr = countArr + toAddStr;
            // 符合条件加入list
            if (toGetCnt == 1) {
                list.add(countArr);
            }
            // 递归
            backtracking(j + 1, n, toGetCnt - 1);
            // 回溯清理并删除这一层增加的内容
            countArr = countArr.substring(0, countArr.length() - toAddStr.length());
        }
    }
}
