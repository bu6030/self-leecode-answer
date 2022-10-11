package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 冒泡排序
 * （1）冒泡排序是一种简单的排序算法，它也是一种稳定排序算法。
 * （2）从左到右遍历，比较每一对相邻的元素，当该对元素顺序不正确时进行交换。一直重复这个过程，直到没有任何两个相邻元素可以交换，就表明完成了排序。
 * （3）说人话，就是类似于冒泡，从左到右，逐个比较当前元素与下一个元素大小，如果小于下一个元素，保持不变，该对元素比较结束，如果当前元素大于下一个元素，则该元素与下一个元素换位置（就像冒泡一样）。之后再与新的下一个元素比较，比较方式保持一致。
 */
public class BubbleSort {
    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(100));
        }
        nums.forEach(s -> System.out.print(s+"-"));
        System.out.println("");
        nums = bubbleSort(nums);
        nums.forEach(s -> System.out.print(s+"-"));
    }

    public static List bubbleSort(List nums) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                // 比较j元素与i元素大小，如果i元素大与j元素，则互换位置
                if ((int)nums.get(j) < (int)nums.get(i)) {
                    int large = (int)nums.get(i);
                    nums.set(i, nums.get(j));
                    nums.set(j, large);
                }
            }
        }
        return nums;
    }
}
