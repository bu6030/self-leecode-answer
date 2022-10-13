package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 归并排序
 * （1）归并排序（Merge sort）算法是采用分治法的一个非常典型的应用。该算法采用经典的分治策略（分治法将问题分成一些小的问题然后递归求解，而治的阶段则将分的阶段得到的各答案“修补”在一起，即分而治之)。
 * （2）具体步骤实际上就是把整个列表拆分成若干个小的分组，直到拆分成每一组只有一个元素为止，我的实际做法是在此时直接返回当前元素，因为一个元素没有办法比较，实际只有大于等于2个元素才能比较并替换大小元素位置。
 * （3）当从最底层递归的只有一个元素返回到上一层递归方法后，此时存在了两个元素，例如23和35这一组，比较两个元素的大小，并按照从小到大排列好两个元素的顺序为23，35，然后继续返回上一层递归方法。
 * （4）返回到这一层递归方法后，其中的元素多了，此时每一组有2个元素，例如{23,35}和{12,34}这两组元素比较，分别取出每一组的第一个比较大小，将较小的插入到新列表首位，也就是23和12比较，将12插入到新列中{12}，接下来已经取出的这一组取下一个值与另一组元素的首位比较，也就是23和34比较，将23插入到新列表中{12,23}，接下来比较35和34，将34插入到新列表中{12,23,34}，这样右边这一组取完所有值了，接下里直接把左边这一组剩下的值直接逐个放入到新列表中，结果为{12,23,34,35}，返回到上一次递归中。
 * （5）这样直到最后跳出递归方法，全部元素已经排序完成了。
 */
public class MergeSort {

    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums.add(random.nextInt(100));
        }
        nums.forEach(s -> System.out.print(s + "-"));
        System.out.println("");
        nums = mergeSort(nums, 0, nums.size() - 1);
        nums.forEach(s -> System.out.print(s + "-"));
    }

    public static List mergeSort(List nums, int startIndex, int endIndex) {
        // 说明拆分到当前list只有一个值，不需要比较直接返回，只有两个值以上才开始比较并按照大小修改顺序
        if (startIndex == endIndex) {
            return nums;
        }
        // 计算拆分位置
        int mid = (startIndex + endIndex) / 2;
        mergeSort(nums, startIndex, mid);
        mergeSort(nums, mid + 1, endIndex);

        // 开始比较从startIndex到endIndex位置
        int i = startIndex;
        int j = mid + 1;
        List newNums = new ArrayList();
        // 分别比较左部分（从startIndex到mid）与右部分（从mid+1到endIndex）
        while (i <= mid && j <= endIndex) {
            // 分别从左部分逐个取出与右部分逐个取出，分别将较小的放到新列表newNums中
            if ((int) nums.get(i) > (int) nums.get(j)) {
                newNums.add(nums.get(j));
                j++;
            } else {
                newNums.add(nums.get(i));
                i++;
            }
        }
        // 上面循环完成后，如果左部分没有循环完成，将左部分的所有值逐个放入到新列表newNums中
        while (i <= mid) {
            newNums.add(nums.get(i));
            i++;
        }
        // 上面循环完成后，如果右部分没有循环完成，将右部分的所有值逐个放入到新列表newNums中
        while (j <= endIndex) {
            newNums.add(nums.get(j));
            j++;
        }
        // 遍历将新列表newNums的值插入到对应老列表nums的位置中替换
        for (int k = startIndex, l = 0; k <= endIndex; k++, l++) {
            nums.set(k, newNums.get(l));
        }
        return nums;
    }
}
