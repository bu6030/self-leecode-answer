package com.xuesong.algorithm;

import java.util.HashMap;

/**
 * 动态规划
 * 我们来看个具体的算法题目来了解动态规划，一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class DynamicMethod {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 1 };
        System.out.println(dynamicMethod(nums1));
        int[] nums2 = { 2, 7, 9, 3, 1 };
        System.out.println(dynamicMethod(nums2));
    }

    public static int dynamicMethod(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        HashMap sum = new HashMap();
        sum.put(0, nums[0]);
        sum.put(1, Math.max(nums[0], nums[1]));
        // 按照咱们总结的递推公式来挨个计算
        for (int i = 2; i < len; i++) {
            sum.put(i, Math.max(nums[i] + (int) sum.get(i - 2), (int) sum.get(i - 1)));
        }
        return (int) sum.get(len - 1);
    }
}
