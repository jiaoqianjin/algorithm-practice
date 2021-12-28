package leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/25 17:04
 **/

public class codeTop23_全排列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        getPermutationCore(nums, 0);
        return res;
    }

    private void getPermutationCore(int[] nums, int k) {
        if (k == nums.length) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(list);
        }
        for (int i = k; i < nums.length; i++) {
            swap(nums, i, k);
            getPermutationCore(nums, k + 1);
            // 回溯
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        codeTop23_全排列 test = new codeTop23_全排列();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(test.permute(nums));
    }
}
