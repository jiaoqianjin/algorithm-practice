package leetcode;

import java.util.Scanner;

/**
 * Description： LeetCode 474
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/6/6 11:12
 **/

public class 一和零 {
    public static int findMaxForm(String[] strs, int m, int n) {

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = new String[]{"10", "0", "1"};
        int m = 1;
        int n = 1;

        findMaxForm(strs, m, n);
    }
}
