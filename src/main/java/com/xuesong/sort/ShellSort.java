package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 希尔排序
 * （1）希尔排序是针对简单插入排序时遇到的一些问题，例如当数组 arr = {2,3,4,5,6,1} 这时需要插入的数 1(最小)，这样的过程是：
 * {2,3,4,5,6,6}
 * {2,3,4,5,5,6}
 * {2,3,4,4,5,6}
 * {2,3,3,4,5,6}
 * {2,2,3,4,5,6}
 * {1,2,3,4,5,6}
 * （2）因此当需要插入的数是较小的数时，后移的次数明显增多，对效率有影响。
 * （3）希尔排序是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
 * （4）希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序，随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 */
public class ShellSort {

    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(100));
        }
        nums.forEach(s -> System.out.print(s + "-"));
        System.out.println("");
        nums = shellSort(nums);
        nums.forEach(s -> System.out.print(s + "-"));
    }

    public static List shellSort(List nums) {
        // 初始化第一次分两组
        int group = 2;
        // 循环增加分组数，逐渐降低比较大小的两个索引位置的间隙gap
        // 遍历完一次，增加一次group大小，也就是降低比较大小的两个索引位置的间隙gap
        for (int gap = nums.size() / group; gap >= 1; group *= 2, gap = nums.size() / group) {
            // 从左到右开始遍历数组
            for (int i = 0; i < nums.size() && i + gap < nums.size(); i++) {
                // 比较i元素与i+gap元素大小，如果i元素大与i+gap元素，则互换位置
                if ((int) nums.get(i + gap) < (int) nums.get(i)) {
                    int large = (int) nums.get(i);
                    nums.set(i, nums.get(i + gap));
                    nums.set(i + gap, large);
                }
            }
        }
        return nums;
    }
}
