package com.xuesong.algorithm;

/**
 * 二分查找
 * 前提数组是已经排好顺序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        // 初始化数据
        int arr[] = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = i;
        }
        // 开始处理
        int result = bindarySearch(arr, 0, arr.length - 1, 21);
        System.out.println(result);
    }

    private static int bindarySearch(int arr[], int low, int high, int target) {
        // 当处理到最后一次，如果已经达到最大或最小时，仍然不是返回错误-1
        if (low == high && target != arr[low]) {
            return -1;
        }
        // 计算中位值
        int mid = (low + high) / 2;
        // 比较目标与中位值大小，相等返回目标
        if (target == arr[mid]) {
            return target;
            // 目标大于中位值，二分当前数组，并到右侧大的一部分数组继续查找
        } else if (target > arr[mid]) {
            return bindarySearch(arr, mid + 1, high, target);
            // 目标小于中位值，二分当前数组，并到左侧小的一部分数组继续查找
        } else {
            return bindarySearch(arr, low, mid - 1, target);
        }
    }
}
