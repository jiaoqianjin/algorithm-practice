package leetcode.codetop;

import util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/11/26 13:44
 **/

public class codeTop09_两数之和 {
    /**
     * 功能描述: 解题思路
     * 扫描数组，将元素存入map,元素下标作为value,元素作为key,
     * 存入时判断是否存在target-cur的值，
     * 如果存在，取出该元素
     *
     * @author jiaoqianjin
     * @date 2021/11/26
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 计算差值
            int temp = target - nums[i];
            // 判断map中是否存在与差值相等的元素，存在取出元素下标
            if (map.containsKey(temp)) {
                Integer integer = map.get(temp);
                res[0] = integer;
                res[1] = i;
            } else { // 不存在，将当前元素存入map
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public int[] twoSum1(int[] nums, int target) {
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
        codeTop09_两数之和 test = new codeTop09_两数之和();
        int[] nums = new int[]{3, 4, 5, 6, 8};
        int target = 6;
        int[] ints = test.twoSum1(nums, target);
        Util.printArray(ints);
    }
}
