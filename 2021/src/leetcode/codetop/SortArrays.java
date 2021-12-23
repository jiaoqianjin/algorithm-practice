package leetcode.codetop;

import util.Util;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/22 13:43
 **/

public class SortArrays {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 功能描述: 快速排序：
     * 选取目标值，将比目标值小的元素放左边，比目标值大的元素放在右边，
     * 对左边元素区间和右边元素区间重复上一步操作
     *
     * @param nums  待排序数组
     * @param left  区间左指针
     * @param right 区间右指针
     * @author jiaoqianjin
     * @date 2021/11/22
     */
    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            //  获取中间目标值
            int p = partition1(nums, left, right);
            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }
    }

    /**
     * 功能描述: 单向扫描
     */
    private int partition(int[] nums, int left, int right) {
        int target = nums[left];
        int pivot = left + 1;
        while (pivot <= right) {
            if (nums[pivot] <= target) {
                pivot++;
            } else {
                swap(nums, pivot, right);
                right--;
            }
        }
        swap(nums, left, right);
        return right;
    }

    /**
     * 功能描述: 双向扫描
     */
    private int partition1(int[] nums, int left, int right) {
        int target = nums[left];
        // 左指针
        int pivot = left + 1;
        // 右指针
        int bigger = right;
        while (pivot <= bigger) {
            // 左指针，不停往右走，直到遇到大于目标值的元素
            while (pivot <= bigger && nums[pivot] <= target) {
                pivot++;
            }
            // 右指针，不停往左走，直到遇到小于目标值的元素
            while (pivot <= bigger && nums[bigger] > target) {
                bigger--;
            }
            if (pivot <= bigger) {
                swap(nums, pivot, bigger);
            }
        }
        swap(nums, left, bigger);
        return bigger;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortArrays sortArrays = new SortArrays();
        int[] arr = {1, 5, 2, 6, 4, 8, 9, 3, 10, 2, 5, 8, 0, 1, 5, 9, 4, 8, 6};
        sortArrays.sortArray(arr);
        Util.printArray(arr);
    }
}
