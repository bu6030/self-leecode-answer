package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 桶排序
 * （1）桶排序（Bucket sort）或所谓的箱排序，是一个排序算法，工作的原理是将数组分到有限数量的桶里。每个桶再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序），最后依次把各个桶中的记录列出来记得到有序序列。
 * （2）例如数列{21，42，38，14，34，35，9，24，16，40，29，48，33，17，30}，分成五个桶，找出最大数48，最小数9，差值为39，分成五个桶的话，每个桶防范围39/5=7.8，向上取整为8，因此五个桶的范围分别是9-17，18-26，27-35，36-43，44-52的五个桶。
 * （3）根据各个桶范围分别将数列放入到五个桶中，如下：
 * 桶1 14，9，16，17，
 * 桶2 21，24，
 * 桶3 34，35，29，33，30
 * 桶4 42，38，40，
 * 桶5 48
 * （5）分别对五个桶排序，得到如下：
 * 桶1 9，14，16，17，
 * 桶2 21，24，
 * 桶3 29，30，33，34，35，
 * 桶4 38，40，42，
 * 桶5 48
 * （6）分别从桶1至桶5把所有值逐个取出修改原有数列，得到结果
 * {9，14，16，17，21，24，29，30，33，34，35，38，40，42，48}
 */
public class BucketSort {
    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums.add(random.nextInt(100));
        }
        nums.forEach(s -> System.out.print(s + "-"));
        System.out.println("");
        nums = bucketSort(nums);
        nums.forEach(s -> System.out.print(s + "-"));
    }

    public static List bucketSort(List nums) {
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
        // 计算最大最小差值，并分成5组，计算出每组范围
        int gap = (int) Math.ceil(Double.valueOf(max - min) / 5);
        int[][] bucket = new int[5][nums.size()];
        int[] bucketIndex = new int[5];
        for (int i = 0; i < nums.size(); i++) {
            int index = ((int) nums.get(i) - min) / gap;
            if (index >= 5) {
                System.out.println("====");
            }
            bucket[index][bucketIndex[index]++] = (int) nums.get(i);
        }
        // 分别对每个桶排序，咱们就直接冒泡排序了
        for (int i = 0; i < 5; i++) {
            bucket[i] = bubbleSort(bucket[i], bucketIndex[i]);
        }
        // 遍历上面的桶，逐个取出放入到新的list中
        List newNums = new ArrayList();
        for (int j = 0; j < bucket.length; j++) {
            for (int k = 0; k < bucketIndex[j]; k++) {
                newNums.add(bucket[j][k]);
            }
        }
        // 将新list返回
        return newNums;
    }

    public static int[] bubbleSort(int[] nums, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                // 比较j元素与i元素大小，如果i元素大与j元素，则互换位置
                if (nums[j] < nums[i]) {
                    int large = nums[i];
                    nums[i] = nums[j];
                    nums[j] = large;
                }
            }
        }
        return nums;
    }
}
