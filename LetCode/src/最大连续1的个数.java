/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 10:05
 **/

public class 最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(count,max);
                count = 0;
            }

        }
        return Math.max(count,max);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(new 最大连续1的个数().findMaxConsecutiveOnes(nums));
    }
}
