package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description： 面试题3：数组中重复的数字
 * 在一个长度为n的数组里所有数字都在0-n-1范围内，数组中有些数字是重复的，但是不知道有几个数字重复了，也不知道每个数字重复了几次
 * 请找出数组中任意一个重复数字
 *
 * @author jiaoqianjin
 * Date: 2021/8/18 9:40
 **/

public class Three {

    /**
     * 功能描述: 哈希表实现（时间O(n),空间O(n)）
     *
     * @param arr 待查数组
     * @return int 重复数字
     * @author jiaoqianjin
     * @date 2021/8/18
     */
    public int getRepeat(int[] arr) {
        if (arr.length <= 1 || arr == null) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();

        for (int value : arr) {
            if (!set.add(value)) {
                return value;
            }
        }
        return -1;
    }

    /**
     * 功能描述: 数组实现（时间O(n),空间O(1)）
     *
     * @param arr 待查数字
     * @return int 重复数字
     * @author jiaoqianjin
     * @date 2021/8/18
     */
    public int getRepeat2(int[] arr) {
        if (arr.length <= 1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 功能描述: 不修改数组找出重复的数字
     *
     * @param arr 待找数组
     * @return int 结果
     * @author jiaoqianjin
     * @date 2021/8/18
     */
    public int getRepeat3(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int a : arr) {
            if (a < 1 || a > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }
        int low = 1;
        int high = arr.length - 1;
        int mid, count;
        while (low <= high) {
            mid = ((high - low) >> 1) + low;
            count = countRange(arr, low, mid);
            if (low == high) {
                if (count > 1) {
                    return low;
                } else {
                    break;
                }
            }
            if (count > mid - low + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    /**
     * 功能描述: 判断数字在数组中出现的次数
     *
     * @param arr   数组
     * @param start 开始
     * @param mid   结束
     * @return int 次数
     * @author jiaoqianjin
     * @date 2021/8/18
     */

    private int countRange(int[] arr, int start, int mid) {
        if (arr == null) {
            return 0;
        }

        int count = 0;
        for (int a : arr) {
            if (a >= start && a <= mid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Three three = new Three();
        int[] arr = new int[]{4, 6, 5, 1, 2, 5, 3};
        System.out.println(three.getRepeat3(arr));
    }
}
