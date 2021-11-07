package leetcode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Description： 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/8/7 20:51
 **/

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        for (int i = 0, l = 0, r = 0; i < m + n; i++) {
            if (l >= m) {
                res[i] = nums2[r++];
            } else if (r >= m) {
                res[i] = nums1[l++];
            } else if (nums1[l] < nums2[r]) {
                res[i] = nums1[l++];
            } else {
                res[i] = nums2[r++];
            }


        }
        nums1 = Arrays.copyOf(res, nums1.length);
        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums1 = new int[]{1};
        int m = 1;
        int[] nums2 = new int[]{};
        int n = 0;
        Merge merge = new Merge();
        merge.merge(nums1, m, nums2, n);
    }
}
