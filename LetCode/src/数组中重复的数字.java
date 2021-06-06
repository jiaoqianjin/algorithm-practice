/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 10:29
 **/

public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(res[nums[i]] > 0) {
                return nums[i];
            }
            if(res[nums[i]] == 0) {
                res[nums[i]] ++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 5, 2};
        System.out.println(new 数组中重复的数字().findRepeatNumber(a));
    }
}
