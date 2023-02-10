package com.xuesong.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 堆排序
 * （1）堆排序是利用堆数据结构而设计的一种排序算法，堆排序是一种选择排序，其最坏，最好，平均时间复杂度均为O(nlogn)，同时也是不稳定排序。
 * （2）咱们使用的是大顶堆或者小顶堆。
 * （3）堆是具有以下性质的完全二叉树，每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆，或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
 * 升序采用大顶堆，降序采用小顶堆。
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 * （4）实际上，堆排序的算法就是自底向上排序，遍历取出整棵树种最大的节点，放到堆顶，这样堆里面最大的值就在堆顶了，因此最大的元素已经排序完成，然后将堆顶元素与堆最后一个元素调换顺序，放到最后，这样对去掉最后一个元素后的新堆重新自底向上排序，遍历出最大的元素，放到堆顶，再次对该元素与新堆的最后一个元素调换顺序，再次去掉该元素生成新堆，一遍一遍的遍历，到最后，实际上就是从小打到排号顺序的元素了。
 * （5）虽然说是自底向上排序，但是堆实际上是一个棵树，因此只需要找到最后一个元素的所在子树的根节点即可，实际上也就是最后一个非叶子节点。因此也就是从后向前逐个遍历每一个非叶子结点，比较当前根节点与两个子节点比较大小，找到最大的元素，放在当前子树的根节点即可
 * （6）咱们手动走一波逻辑，例如数组{4，6，3，5，9}，堆如下图：
 *
 *      4
 *     /  \
 *    6    3
 *   / \
 *  5   9
 * （7）找到最后一个非叶子节点，也就是6所在元素位置，比较6和两个子节点大小，6>5，不需要替换，6<9，因此将6与9的位置替换，新数组{4，9，3，5，6}，堆如下图：
 *
 *      4
 *     /  \
 *    9    3
 *   / \
 *  5   6
 * （8）从后向前找下一个非叶子节点，也就是4所在元素位置，比较4和两个子节点大小，4<9,因此将4与9的位置替换，继续比较9>3，不需要替换，新数组{9，4，3，5，6}，堆如下图：
 *
 *      9
 *     /  \
 *    4    3
 *   / \
 *  5   6
 * （9）这时候需要特殊操作，将9（已经最大，有序了）与堆最后一个元素替换位置，新数组{6，4，3，5，9}，堆如下图：
 *
 *      6
 *     /  \
 *    4    3
 *   / \
 *  5   9
 * （10）此时再次针对数组前四个元素重新进行堆排序，数组{6，4，3，5，9（忽略该元素，已经有序）}，堆如下图：
 *
 *      6
 *     /  \
 *    4    3
 *   /
 *  5
 * （11）找到最后一个非叶子节点，也就是4所在元素位置，比较4和子节点大小，4<5，因此将4与5的位置替换，新数组{6，5，3，4，9（忽略该元素，已经有序）}，堆如下图：
 *
 *      6
 *     /  \
 *    5    3
 *   /
 *  4
 * （12）从后向前找下一个非叶子节点，也就是6所在元素位置，比较6和两个子节点大小，6>5，不需要替换，继续比较6>3，不需要替换，数组不变{6，5，3，4，9（忽略该元素，已经有序）}，堆如下图：
 *
 *      6
 *     /  \
 *    5    3
 *   /
 *  4
 * （13）这时候需要特殊操作，将6（已经最大，有序了）与堆最后一个元素替换位置，新数组{4，5，3，6，9（忽略该元素，已经有序）}，堆如下图：
 *
 *      4
 *     /  \
 *    5    3
 *   /
 *  6
 * （14）此时再次针对数组前三个元素重新进行堆排序，数组{4，5，3，6（忽略该元素，已经有序），9（忽略该元素，已经有序）}，堆如下图：
 *
 *      4
 *     /  \
 *    5    3
 * （15）找到最后一个非叶子节点，也就是4所在元素位置，比较4和两个子节点大小，4<5，因此将4与5的位置替换，再次比较5>3，不需要替换，新数组{5，4，3，6（忽略该元素，已经有序），9（忽略该元素，已经有序）}，堆如下图：
 *
 *      5
 *     /  \
 *    4    3
 * （16）这时候需要特殊操作，将5（已经最大，有序了）与堆最后一个元素替换位置，新数组{3，4，5，6（忽略该元素，已经有序），9（忽略该元素，已经有序）}，堆如下图：
 *
 *      3
 *     /  \
 *    4    5
 * （17）此时再次针对数组前两个元素重新进行堆排序，数组{3，4，5（忽略该元素，已经有序），6（忽略该元素，已经有序），9（忽略该元素，已经有序）}，堆如下图：
 *
 *      3
 *     /
 *    4
 * （18）找到最后一个非叶子节点，也就是3所在元素位置，比较3和子节点大小，3<4，因此将3与4的位置替换，新数组{4，3，5（忽略该元素，已经有序），6（忽略该元素，已经有序），9（忽略该元素，已经有序）}，堆如下图：
 *
 *      4
 *     /
 *    3
 * （19）这时候需要特殊操作，将4（已经最大，有序了）与堆最后一个元素替换位置，新数组{3，4，5（忽略该元素，已经有序），6（忽略该元素，已经有序），9（忽略该元素，已经有序）}，堆如下图：
 *
 *      3
 *     /
 *    4
 * （20）此时再次针对数组第一个元素重新进行堆排序，数组{3，4（忽略该元素，已经有序），5（忽略该元素，已经有序），6（忽略该元素，已经有序），9（忽略该元素，已经有序）}，堆如下图：
 *
 *      3
 * （21）此时没有非叶子结点了，排序完成，此时数组已经有序，{3，4，5，6，9}，排序完成。
 */
public class HeapSort {
    public static void main(String[] args) {
        List nums = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums.add(random.nextInt(10));
        }
        nums.forEach(s -> System.out.print(s + "-"));
        System.out.println("");
        nums = heapSort(nums);
        nums.forEach(s -> System.out.print(s + "-"));
    }

    public static List heapSort(List nums) {
        // 从右向左遍历
        for (int i = nums.size() - 1; i >= 0; i--) {
            int j = i;
            // 取得最后一个非叶子节点
            int lastNotLeafIndex = (j - 1) / 2;
            while (lastNotLeafIndex >= 0 && i > 1) {
                // 与左子节点比较，如果小于子节点，则替换顺序
                if ((int) nums.get(lastNotLeafIndex) < (int) nums.get(lastNotLeafIndex * 2 + 1)) {
                    swap(nums, lastNotLeafIndex, lastNotLeafIndex * 2 + 1);
                }
                // 与右子节点比较，如果小于子节点，则替换顺序
                if ((lastNotLeafIndex * 2 + 2) <= i - 1 && (int) nums.get(lastNotLeafIndex) < (int) nums.get(lastNotLeafIndex * 2 + 2)) {
                    swap(nums, lastNotLeafIndex, lastNotLeafIndex * 2 + 2);
                }
                // 继续下一个非椰子节点
                j--;
                lastNotLeafIndex = (j - 1) / 2;
            }
            // 替换获取到的堆顶节点与最后一个节点顺序
            swap(nums, i, 0);
        }
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