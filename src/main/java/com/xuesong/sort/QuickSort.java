package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 快速排序
 （1）快速排序是一个既高效又不浪费空间的一种排序算法。
 （2）咱们来直接讲算法步骤，例如一个随机数列，5 1 3 8 2 4 0 6 7 10 9。
 （3）首先在这个序列中随便找一个数作为基准数，一般选择第一个数，也就是5作为基准。
 （4）设置一个索引值j，从右到左逐个选择一个，第一个选择了9，与基准书5比较，9大于5，则跳过直接下一个，选择10，大于5，继续跳过直接下一个，选择7，大于5，继续跳过直接下一个，选择6，大于5，继续跳过直接下一个，选择0，小于5，记住这个当前j的位置，也就是当前列表索引位置。

 5 1 3 8 2 4 0 6 7 10 9
 j
 （5）接下来，设置一个索引值i，从左往右逐个选择（跳过基准数5的位置），逐个与基准数5比较大小，选择第一个1，小于5，继续跳过直接下一个，选择3，小于5，继续跳过直接下一个，选择8，大于5，此时i索引位置如下：

 5 1 3 8 2 4 0 6 7 10 9
 i     j
 （6）此时替换i与j位置的值，使得大于基准数5的在右边，小于基准数5的在左边。

 5 1 3 0 2 4 8 6 7 10 9
 i     j
 （7）继续索引j的向左移动，接下来选择了4，与基准数5比较，小于5，记住索引j位置。

 5 1 3 0 2 4 8 6 7 10 9
 i   j
 （8）继续索引i的向右移动，接下来选择2，与基准数5比较，小于5，继续跳过直接下一个，选择4，此时注意，i和j的位置相同了。

 5 1 3 0 2 4 8 6 7 10 9
 j
 i
 （9）此时可以看出来了索引i/j的位置很特殊，现在索引i/j左边的数，除了基准数自己，都小于5，索引i/j右边的数，都大于5。因此需要替换i/j的数和基准数的位置后，此时索引i/j左边的数都小于5，右边的数都大于5。

 4 1 3 0 2 5 8 6 7 10 9
 j
 i
 （10）接下来，5的位置，可以把这个数列拆成了两个数列，4 1 3 0 2和 8 6 7 10 9，接下来通过分治的方式，分别对左边数列后右边数列继续上面同样的步骤，4 1 3 0 2选择4作为基准数比较，8 6 7 10 9选择8作为基准数比较。
 （11）直到每个序列拆分到只有一个数的时候，说明已经是正确的顺序了，返回即可。排序完成。
 */
public class QuickSort {
    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums.add(random.nextInt(100));
        }
        nums.forEach(s -> System.out.print(s + "-"));
        System.out.println("");
        nums = quickSort(nums, 0, nums.size() - 1);
        nums.forEach(s -> System.out.print(s + "-"));
    }

    public static List quickSort(List nums, int startIndex, int endIndex) {
        if (startIndex == endIndex || startIndex > endIndex) {
            return nums;
        }
        int selectIndex = startIndex;
        int j = endIndex;
        int i = startIndex + 1;
        while (i < j) {
            // 从右向左逐个与基准数比较，找到小于基准数的j位置
            while ((int) nums.get(j) >= (int) nums.get(selectIndex) && i < j) {
                j--;
            }
            // 从左向右逐个与基准数比较，找到大于基准数的j位置
            while ((int) nums.get(i) <= (int) nums.get(selectIndex) && i < j) {
                i++;
            }
            // 如果i与j相等，说明找到了基准数的正确位置
            if (i == j) {
                break;
            }
            // 右边小于基准数的值与左边大于基准数的值替换位置
            swap(nums, j, i);
        }
        // 内部遍历完成，替换基准数与i/j的数值
        swap(nums, selectIndex, i);
        // 分治，在i/j的位置拆分为两组，i/j左边一组，右边一组，分别快速排序
        quickSort(nums, startIndex, i - 1);
        quickSort(nums, i + 1, endIndex);
        return nums;
    }

    /**
     * 交换位置
     * 
     * @param nums
     * @param left
     * @param right
     */
    public static void swap(List nums, int left, int right) {
        int current = (int) nums.get(left);
        nums.set(left, nums.get(right));
        nums.set(right, current);
    }
}
