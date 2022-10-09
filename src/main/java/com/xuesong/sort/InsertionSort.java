package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(100));
        }
        nums.forEach(s -> System.out.print(s+"-"));
        System.out.println("");
        nums = selectionSort(nums);
        nums.forEach(s -> System.out.print(s+"-"));
    }

    public static List selectionSort(List nums) {
        for (int i = 1; i < nums.size(); i++) {
            for (int j = i; j >= 1; j--) {
                // 比较当前位置与前一个位置大小，如果当前数值小与前一个数值，则将当前数值插入到前面
                if ((int)nums.get(j) < (int)nums.get(j-1)) {
                    int old = (int)nums.get(j-1);
                    nums.set(j-1, (int)nums.get(j));
                    nums.set(j, old);
                }
            }
        }
        return nums;
    }

}
