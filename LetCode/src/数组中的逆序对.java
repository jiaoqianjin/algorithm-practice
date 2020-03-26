/**
 * @Auther:焦前进
 * @Data:2020/3/23
 * @Description:
 */
public class 数组中的逆序对 {
    static int res = 0;
    public static int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        mergeSort(nums,0,nums.length-1);
        return res;
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + ((r-l)>>1);
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] helper = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1<=mid && p2 <= r){
            if(nums[p1] <= nums[p2]){
                helper[i++] = nums[p1++];
            }else {
                helper[i++] = nums[p2++];
                res += mid-p1+1;
            }
        }
        while (p1<=mid){
            helper[i++] = nums[p1++];
        }
        while (p2 <= r) {
            helper[i++] = nums[p2++];
        }
        //把最终的结果复制给原数组
        for (i = 0; i < helper.length; i++) {
            nums[l + i] = helper[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7};
        System.out.println(reversePairs(arr));
    }

}
