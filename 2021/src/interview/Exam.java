package interview;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/18 14:55
 **/

public class Exam{
    public static void main(String[] args){
        Solution S = new Solution();
        int[] nums = new int[] {1,2,1,3,2,5};
        int[] a = S.singleNumber(nums);
        for(int i = 0; i< 2 ;i++) {
            System.out.print(a[i] + " ");
        }

    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int a = nums[0];
        int b = 0;
        int c = 0;
        int n = 1;
        int[] result = new int[2];
        for(int i = 1; i<nums.length;i++){
            a ^=nums[i];
        }
        while(true){
            if((a & n )== n ){
                //找到为 1 的位置
                break;
            }
            n *= 2;
        }
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & n )==n){
                b ^= nums[i];
            }else{
                c ^=nums[i];
            }
        }
        result[0] = b;
        result[1] = c;
        return result;
    }
}
