package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 基数排序
 * （1）基数排序，就是按照整数的个位、十位、百位等依次排列元素，局部最优排列最终可以获得全局最优。
 * （2）基数排序可以分为LSD和MSD两种，LSD就是从低位往高位排(个十百…)，MSD是从高位往低位排(…百十个)。
 * （3）咱们通过LSD展示一下集体逻辑，下面这个数列{345,21,342,786,55,2,453,66,98,145,46,76,5,674}
 * （4）首先遍历这些数字，取得最大值786，根据最大值获取到这个数列中存在的个十百位，没有千位及以上。因此只需要分别按照个位，十位，百位遍历分别放入三次桶。
 * （5）先按照个位的各种值放入到10个桶中（因为个位数字只有0-9共计10中数字），放入结果如下。
 *
 * 桶0
 * 桶1 21，
 * 桶2 342，2，
 * 桶3 453，
 * 桶4 674，
 * 桶5 345，55，145，5，
 * 桶6 786，66，46，76，
 * 桶7
 * 桶8 98，
 * 桶9
 * （6）分别从桶0至桶10，逐个取出，逐个修改数列为
 * {21，342，2，453，674，345，55，145，5，786，66，46，76，98}
 * （7）再按照十位的各种值放入到10个桶中（因为十位数字只有0-9共计10中数字），放入结果如下。
 *
 * 桶0 2，5，
 * 桶1
 * 桶2 21，
 * 桶3
 * 桶4 342，345，145，46，
 * 桶5 453，55，
 * 桶6 66，
 * 桶7 674，76，
 * 桶8 786，
 * 桶9 98，
 * （8）分别从桶0至桶10，逐个取出，逐个修改数列为
 * {2，5，21，342，345，145，46，453，55，66，674，76，786，98}
 * （9）再按照百位的各种值放入到10个桶中（因为百位数字只有0-9共计10中数字），放入结果如下。
 *
 * 桶0 2，5，21，46，55，66，76，98，
 * 桶1 145，
 * 桶2
 * 桶3 342，345，
 * 桶4 453，
 * 桶5
 * 桶6 674，
 * 桶7 786，
 * 桶8
 * 桶9
 * （10）分别从桶0至桶10，逐个取出，逐个修改数列为
 * {2，5，21，46，55，66，76，98，145，342，345，453，674，786}
 * （11）排序完成，接下来看代码：
 */
public class RadixSort {
    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            nums.add(random.nextInt(1000));
        }
        nums.forEach(s -> System.out.print(s + "-"));
        System.out.println("");
        nums = countSort(nums);
        nums.forEach(s -> System.out.print(s + "-"));
    }

    public static List countSort(List nums) {
        // 初始化以及获取数列中的最大值最小值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if ((int) nums.get(i) > max) {
                max = (int) nums.get(i);
            }
        }
        // 计算出该数字的个十百千万位，以便计算需要遍历几次
        int cur = 1;
        while (max / (int) Math.pow(10, cur) > 0) {
            cur++;
        }
        System.out.println(cur);
        for (int i = 1; i <= cur; i++) {
            int[][] bucket = new int[10][nums.size()];
            int[] bucketIndex = new int[10];
            // 分别计算，个位，十位，百位的数字
            for (int j = 0; j < nums.size(); j++) {
                int rest = (int) nums.get(j) / ((int) Math.pow(10, i - 1)) % ((int) Math.pow(10, i));
                // 例如969，在取十位的数字时，上面的公式得到的是96，因此需要下面的再次计算
                rest = rest % 10;
                // 存入到对应位数的数字的桶中
                bucket[rest][bucketIndex[rest]++] = (int) nums.get(j);
            }
            // 遍历上面的桶，逐个取出放入到新的list中
            List newNums = new ArrayList();
            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < bucketIndex[j]; k++) {
                    newNums.add(bucket[j][k]);
                }
            }
            // 将新list覆盖回旧list中
            nums = newNums;
        }
        return nums;
    }
}
