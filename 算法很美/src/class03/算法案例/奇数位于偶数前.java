package class03.算法案例;
import util.Util;
/**
 * @Auther:焦前进
 * @Data:2020/3/19
 * @Description:
 * 输入一个整数数组，调整数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分，
 * 要求时间复杂度为O（n)
 */
public class 奇数位于偶数前 {
    /**
     * 使用模式匹配的方法
     * 利用快速排序的思想
     * 左右两个指针，相对而走，
     * 左指针遇到的第一个偶数，
     * 和右指针第一个遇到的奇数交换
     */
    public static int[] sort(int[] arr,int l,int r){
        int left = l; //左指针
        int right = r; //右指针
//        while (left < right){
//            if(arr[left]%2==0 && arr[right]%2!=0){
//                util.swap(arr,left++,right--);
//            }else if (arr[left]%2!=0){
//                left ++;
//            }else if (arr[right]%2==0){
//                right --;
//            }
//        }
        while (left < right){
            while (left < right && arr[left] % 2 != 0) {
                left++;
            }
            while (left < right && arr[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                Util.swap(arr,left,right);
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = Util.generateRandomArray(20,20);
        Util.printArray(arr);
        sort(arr,0,arr.length-1);
        Util.printArray(arr);
    }
}
