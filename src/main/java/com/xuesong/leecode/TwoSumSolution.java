package com.xuesong.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 */

public class TwoSumSolution {
    /**
     * 最基础的，通过两次循环来遍历所有可能组合的和
     * 判断与target是否相等
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            for (int j = i + 1; j < numsLength; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 进阶
     * 通过空间换时间
     * 只循环一次，把所有的值存入到HashMap中，数值为key，索引为value
     * 循环时，判断target与当前值的差，是否与之前存入到HashMap的key值相同
     * 如果相同则就是当前值与HashMap的value为一组，返回结果
     */
    public int[] twoSumHash(int[] nums, int target) {
        Map containsMap = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (containsMap.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = (int) containsMap.get(target - nums[i]);
                return result;
            }
            containsMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumSolution s = new TwoSumSolution();
        int[] nums = { 2, 5, 5, 1 };
        int[] result = s.twoSumHash(nums, 10);
        for (int a : result) {
            System.out.println(a);
        }
    }
}
