package leetcode.hash;

import util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/7/3 16:05
 **/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    /**
     *功能描述: 哈希表实现
     * @param nums 带查找数据
     * @param target 目标
     * @return int[]
     * @author jiaoqianjin
     * @date 2021/7/3
    */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {
        int l = nums.length;
        for (int i = 0; i < l / 2; i++) {
            for (int j = i + 1; j < l; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
                if (nums[l - 1 - i] + nums[j] == target) {
                    return new int[]{l - 1 - i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[]{2, 11, 7, 15};
        int target = 9;
        Util.printArray(twoSum.twoSum3(arr, target));
    }

}
