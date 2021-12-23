package leetcode.codetop;

/**
 * Description：最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author jiaoqianjin
 * Date: 2021/11/25 13:42
 **/

public class codeTop08_最大子序和 {
    /**
     * 功能描述: 递推法
     * 扫描数组，如果左子数组和大于零，则向右走，记录当前和
     * 如果左子数组和小于零，丢弃前一部分数组，重试寻找子数组及子数组和
     *
     * @param nums 待遍历数据
     * @return int
     * @author jiaoqianjin
     * @date 2021/11/25
     */
    public static int maxSubArray(int[] nums) {
        // 记录子数组的和
        int sum = nums[0];
        // 记录子数组的最大和
        int max = sum;
        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 如果当前和>0,累加当前元素
            if (sum > 0) {
                sum += nums[i];
            } else { // 如果子数组和<0,丢弃之前元素
                sum = nums[i];
            }
            // 记录最大子数组和
            max = Math.max(sum, max);
        }
        return max;
    }

    // 动态规划
    public static int maxSubArray1(int[] nums) {
        int sum = 0, max = nums[0];
        for (int x : nums) {
            // 如果左子数组+当前元素 < 当前元素，则丢弃左子数组，记录当前子数组和
            sum = Math.max(sum + x, x);
            // 记录最大子数组和
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray1(nums);
        System.out.println(maxSubArray);
    }
}
