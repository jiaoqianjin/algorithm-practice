package class03.算法案例;

/**
 * @Author 焦前进
 * @Date: 2020/3/28 16:30
 * @Description: 题七：排序树组中找和的因子
 * 给定已排序数组arr和k,不重复打印arr中所有相加和为 k 的不降序二元组
 * 如输入arr={-8,-4,-3,0,2,4,5,8,9,10},k = 10
 * 输出（0，,10）（2,8）
 **/
public class 找和的因子 {
    /**
     * 思路：双指针
     * 如果 arr[left]+arr[right] > k ,right--
     * 如果 arr[left]+arr[right] < k ,left++
     * 如果 arr[left]+arr[right] = k ,left++,同时输出 (arr[left],arr[right])
     * @param arr
     * @param k
     */
    public static void searchSumK(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
//        while (left < right){
//            while (left < right && arr[left] + arr[right] < k) left++;
//            while (left < right && arr[left] + arr[right] > k) right--;
//            if(left < right && arr[left] + arr[right] == k){
//                System.out.println("("+arr[left]+","+arr[right]+")");
//                left ++;
//            }
//        }
        while (left < right) {
            int val = arr[left] + arr[right];
            if (val > k) {// 右指针偏右
                right--;
            } else if (val < k) {
                left++;
            } else {
                System.out.println("(" + arr[left] + "," + arr[right] + ")");
                left++;
            }
        }

    }

    public static void main(String[] args) {
//        int[] arr = {-8, -4, -3, 0, 2, 2, 4, 5, 5, 8, 8, 9, 10, 13};
        int[] arr = {13,10,9,8,8,5,5,4,2,2,0,-3,-4,-8};
        searchSumK(arr,10);
    }
}
