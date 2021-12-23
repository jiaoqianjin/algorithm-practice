package leetcode.codetop;

import util.Util;

/**
 * Description： 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author jiaoqianjin
 * Date: 2021/11/17 13:30
 **/

public class codeTop04_数组中的第K个最大元素 {
    /**
     * 功能描述: 解题思路：
     * 1. 本题最重要的就是对数组进行排序，选择合理的排序算法是解题的关键
     *
     * @param nums 待处理数组
     * @param k    待取出元素顺序
     * @return int 处理后结果
     * @author jiaoqianjin
     * @date 2021/11/17
     */
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        bubbleSort(nums);
//        insertionSort(nums);
        quickSort(nums, 0, nums.length - 1);
//        selectionSort(nums);
        Util.printArray(nums);
        return nums[nums.length - k];
    }

    /**
     * 功能描述: 冒泡排序
     *
     * @param nums 待排序数组
     * @author jiaoqianjin
     * @date 2021/11/17
     */
    private void bubbleSort(int[] nums) {
        int l = nums.length - 1;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 功能描述: 插入排序
     * 无序的元素向有序的数组插入，比数组最后一个数小，交换，不断对比
     *
     * @param nums 待排序数组
     * @author jiaoqianjin
     * @date 2021/11/17
     */
    private void insertionSort(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    /**
     * 功能描述: 选择排序
     *
     * @param num 待排序数组
     * @author jiaoqianjin
     * @date 2021/11/17
     */
    private void selectionSort(int[] num) {
        int l = num.length;
        for (int i = 0; i < l - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < l; j++) {
                temp = num[temp] < num[j] ? temp : j;
            }
            swap(num, i, temp);
        }
    }

    /**
     * 功能描述: 快速排序
     *
     * @param nums 待排序数组
     * @param l    左指针
     * @param r    右指针
     * @author jiaoqianjin
     * @date 2021/11/17
     */
    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);

            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int left = l + 1;
        int right = r;
        while (left <= right) {
            if (pivot >= nums[left]) {
                left++;
            } else {
                swap(nums, left, right);
                right--;
            }
        }
        swap(nums, l, right);
        return right;
    }

    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    public static void main(String[] args) {
        codeTop04_数组中的第K个最大元素 test = new codeTop04_数组中的第K个最大元素();
        int[] nums = new int[]{5, 3, 6, 7, 2, 1};
        System.out.println(test.findKthLargest(nums, 2));

    }
}
