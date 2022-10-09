package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 选择排序
 * （1）选择排序，顾名思义，从左到右遍历，每次选择最小的一个，放到第一个，
 *      之后从第二个元素开始遍历，再次选出最小的，放到第二个，
 *      接下来从第三个元素开始遍历，选出最小的，放到第三个，
 *      直到遍历到最后一个元素，此时已经排序完成。
 * （2）也可以从左向右遍历，选择最大的，放到最后一个元素，
 *      之后再从左到右遍历至倒数第二个元素，依次遍历，同样也可以。
 * （3）选择排序是不稳定的排序方法。稳定不稳定的意思就是在排序过程中，
 *      如果两个键的值相同，那么他们的相对位置不发生变化，不符合该规则的排序算法是不稳定排序算法。
 */
public class SelectionSort {

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
        // 循环遍历取出每次的最小值
        for (int i = 0; i < nums.size(); i++) {
            // 设定最小值
            int min = Integer.MAX_VALUE;
            // 初始化最小值位置
            int index = -1;
            for (int j = i; j < nums.size(); j++) {
                // 如果当前遍历到的值比最小值小则设定最小值为当前遍历到的值，以及记录位置index
                if ((int)nums.get(j) < min) {
                    min = (int)nums.get(j);
                    index = j;
                }
            }
            // 修改本次遍历的列表中的首位与最小值的位置
            int oldFirst = (int)nums.get(i);
            nums.set(i, min);
            nums.set(index, oldFirst);
        }
        return nums;
    }

}
