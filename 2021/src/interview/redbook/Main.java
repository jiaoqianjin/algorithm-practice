package interview.redbook;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/25 16:17
 **/

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -3, 4, 5};
        int s = 10;
        int res = getNum(nums, s);
        System.out.print(res);
    }

    public static int getNum(int[] nums, int target) {
        int start = 0, res = Integer.MAX_VALUE, sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];
            while (sum >= target) {
                res = Math.min(end - start + 1, res);
                sum = sum - nums[start];
                start++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static int getLen(int[] arr, int target) {
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
        }
        if (count < target) {
            return 0;
        }
        int l = 0, r = len - 1;
        while ((count - arr[l] >= target || count - arr[r] >= target) && l <= r) {
            if (arr[l] >= arr[r] && count - arr[l] >= target) {
                count -= arr[l];
                len--;
                l++;
            } else if (arr[l] < arr[r] && count - arr[r] >= target) {
                count -= arr[r];
                len--;
                r--;
            } else if (arr[l] < arr[r] && count - arr[l] >= target) {
                count -= arr[l];
                len--;
                l++;
            }
        }
        return len;
    }
}
