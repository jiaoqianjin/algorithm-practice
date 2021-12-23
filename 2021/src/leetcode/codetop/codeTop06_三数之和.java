package leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description：三数之和
 * 给你一个包含 n 个整数的数组nums，
 * 判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/11/24 13:36
 **/

public class codeTop06_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 枚举第一个数
        for (int first = 0; first < n; ++first) {
            //需要判断是否和上一个数相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始值指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                //需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 保证b在c的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着b的后续增加，就不会有满足a+b+c=0并且b<c的C了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    // 双指针
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 对数组排序
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            // 如果当前值>0,停止循环
            if (nums[i] > 0) {
                return res;
            }
            // 需要和上次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 记录当前值
            int cur = nums[i];
            // 声明双指针
            int left = i + 1, right = len-1;
            while (left < right) {
                int sum = cur + nums[left] + nums[right];
                // 如果三个数相加为0，存入集合
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 跳过相同的枚举数
                    while (left < right && nums[left + 1] == nums[left]) {
                        ++left;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        --right;
                    }
                    ++left;
                    --right;

                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        codeTop06_三数之和 test = new codeTop06_三数之和();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        test.threeSum1(nums).forEach(System.out::println);
    }
}
