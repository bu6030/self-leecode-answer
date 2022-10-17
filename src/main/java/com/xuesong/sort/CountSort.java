package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 计数排序
 （1）计数排序，只适用于整数并且最大值与最小值差值较小的情况。
 （2）具体算法为，例如这个数列a[]为{9, 5, 3, 4, 9, 1, 2, 7, 7，1，4, 6, 1, 3, 4, 9, 7, 9, 10, 0}，取得最大值与最小值，计算最大值与最小值的差值，根据差值大小申请一个空间来存储所有去除重复后的数列，最大值10，最小值0，那么存储的范围就是0-10，因此申请一个可以存储11个值的数组空间，arr[]，并且每个的初始值都为0。
 （3）遍历整个数列，第一个值为9，那么在空间arr[10]的数值+1，第二个值为5，那么在空间arr[6]的数值+1，第三个值为3，那么在空间arr[4]的数值+1，第四个值为4，那么在空间arr[5]的数值+1，第五个值为9，那么在空间arr[10]的数值+1，当前值就变成2了，直至遍历到最后，其中需要注意，原始数列中没有8，因此arr[9]的数值为0，最终得到arr[]数组为：
 {1, 3, 1, 2, 3, 1, 1, 3, 0，4，1}
 （4）再从arr[]数组逐个取值，最小值为0，因此逐个取值排序，arr[0]=1，因此修改a[0] = 0，其他位保持不变，也就是
 {0, 5, 3, 4, 9, 1, 2, 7, 7, 1, 4, 6, 1, 3, 4, 9, 7, 9, 10, 0}
 （5）arr[1]=3，因此从第二位开始修改3位为1，a[1] = 1，a[2] = 1，a[3] = 1，也就是
 {0, 1, 1, 1, 9, 1, 2, 7, 7, 1, 4, 6, 1, 3, 4, 9, 7, 9, 10, 0}
 （6）arr[2]=1，因此在第五位开始修改1位为2，a[4] = 2，也就是
 {0, 1, 1, 1, 2, 1, 2, 7, 7, 1, 4, 6, 1, 3, 4, 9, 7, 9, 10, 0}
 （7）arr[3]=2，因此在第六位开始修改2位为3，a[5] = 3，a[6] = 3，也就是
 {0, 1, 1, 1, 2, 3, 3, 7, 7, 1, 4, 6, 1, 3, 4, 9, 7, 9, 10, 0}
 （8）arr[4]=3，因此在第八位开始修改3位为4，a[7] = 4，a[8] = 4，a[9] = 4，也就是
 {0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 6, 1, 3, 4, 9, 7, 9, 10, 0}
 （9）arr[5]=1，因此在第十一位开始修改1位为5，a[10] = 5，也就是
 {0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 1, 3, 4, 9, 7, 9, 10, 0}
 （10）arr[6]=1，因此在第十二位开始修改1位为6，a[11] = 6，也就是
 {0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 1, 3, 4, 9, 7, 9, 10, 0}
 （11）arr[7]=3，因此在第十三位开始修改1位为7，a[12] = 7，a[13] = 7，a[14] = 7，也就是
 {0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 7, 9, 7, 9, 10, 0}
 （12）arr[8]=0，因此数列中没有8，无需修改直接跳过
 {0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 7, 9, 7, 9, 10, 0}
 （13）arr[9]=4，因此在第十六位开始修改4位为9，a[15] = 9，a[16] = 9，a[17] = 9，a[18] = 9，也就是
 {0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 7, 9, 9, 9, 9, 0}
 （13）arr[10]=1，因此在第十九位开始修改1位为10，a[19] = 10，也就是
 {0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 7, 9, 9, 9, 9, 10}
 */
public class CountSort {
    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums.add(random.nextInt(10));
        }
        nums.forEach(s -> System.out.print(s + "-"));
        System.out.println("");
        nums = countSort(nums);
        nums.forEach(s -> System.out.print(s + "-"));
    }

    public static List countSort(List nums) {
        // 初始化以及获取数列中的最大值最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if ((int) nums.get(i) > max) {
                max = (int) nums.get(i);
            }
            if ((int) nums.get(i) < min) {
                min = (int) nums.get(i);
            }
        }
        // 计算最大值最小值的差值
        int arrSize = max - min + 1;
        // 根据差值初始化计数数组
        int arr[] = new int[arrSize];
        // 根据nums中的各个数值的重复度设定计数数组值
        for (int i = 0; i < nums.size(); i++) {
            int index = (int) nums.get(i) - min;
            arr[index]++;
        }
        // 输出计数数组的各项值
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "-");
        }
        System.out.println("");
        // 根据计数数组的各项值重新排列nums
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums.set(index, min + i);
                index++;
            }
        }
        return nums;
    }
}
