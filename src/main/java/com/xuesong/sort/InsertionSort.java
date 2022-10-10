package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 插入排序
 * （1）插入排序，从左到右遍历，首先选中第一个元素，前面没有元素，保持不变。
 * （2）接下来遍历到第二个元素，将第二个元素与第一个元素比较，如果大于则保持当前位置不变，本次完成；如果小于第一个元素，则将该元素插入到第一个元素前面，此时此元素已经到了第一个元素位置，前面没有元素，本次完成。
 * （3）继续遍历到第三个元素，将第三个元素，与第二个元素比较，如果大于第二个元素，则保持该位置不变，本次完成，如果小于第二个元素，则将该元素插入到第二个元素前面，继续与第一个元素比较，如果大于第一个元素，则保持该位置不变，本次完成，如果小与第一个元素，则将该元素插入到第一个元素前面，此时此元素已经到了第一个元素位置，前面没有元素，本次完成。
 * （4）依次遍历所有元素，直至最后一个元素找插入到最后一个大于该元素的元素前面。
 * （5）选择排序是稳定的排序。
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
