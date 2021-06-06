import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/1/20 19:45
 **/

public class 三个最大数的乘积 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length - 1]*nums[length-2]*nums[length-3],nums[length - 1]*nums[0]*nums[1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println( new 三个最大数的乘积().maximumProduct(arr));
    }
}
