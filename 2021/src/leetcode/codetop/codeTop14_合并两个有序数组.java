package leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/11/30 13:59
 **/

public class codeTop14_合并两个有序数组 {
    /**
     * 功能描述: 双指针，需要辅助空间
     * 时间复杂度：O(m+n)。
     * 空间复杂度：O(m+n)O(m+n)。
     *
     * @param nums1 数组1
     * @param m     数组1元素数目
     * @param nums2 数组2
     * @param n     数组2元素数据
     * @author jiaoqianjin
     * @date 2021/11/30
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        for (int i = 0, l = 0, r = 0; i < m + n; i++) {
            if (l >= m) {
                res[i] = nums2[r++];
            } else if (r >= n) {
                res[i] = nums1[l++];
            } else if (nums1[l] <= nums2[r]) {
                res[i] = nums1[l++];
            } else {
                res[i] = nums2[r++];
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    /**
     * 功能描述: 逆向双指针，不需要辅助空间
     * 时间复杂度：O(m+n)。
     * 空间复杂度：O(1)。
     *
     * @param nums1 数组1
     * @param m     数组1元素数目
     * @param nums2 数组2
     * @param n     数组2元素数据
     * @author jiaoqianjin
     * @date 2021/11/30
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1, b = n - 1;
        int tail = m + n - 1;
        int cur;
        while (a >= 0 || b >= 0) {
            if (a < 0) {
                cur = nums2[b--];
            } else if (b < 0) {
                cur = nums1[a--];
            } else if (nums1[a] <= nums2[b]) {
                cur = nums2[b--];
            } else {
                cur = nums1[a--];
            }
            nums1[tail--] = cur;
        }
    }
}
