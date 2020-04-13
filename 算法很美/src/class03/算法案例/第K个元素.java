package class03.算法案例;

import util.Util;

/**
 * @Auther:焦前进
 * @Data:2020/3/19
 * @Description:
 * 以尽量搞得效率求出一个乱序数组中的按数值顺序的第K个值
 */
public class 第K个元素 {
    /**
     *根据快速排序的思路，每次 K 和 主元所处的位置进行对比，
     * K < 目标值位置，则只查 主元 左边的区间
     * K > 目标值位置， 则只查 主元 右边的区间
     * @param arr 目标数组
     * @param l 开始下标
     * @param r 结束下标
     * @param k 目标值
     * @return
     */
    public static int selectK(int[]arr,int l,int r,int k){
        int q = partition(arr,l,r); //主元下标
        int qk = q - l + 1; //主元位于第几个元素
        if(qk == k) return arr[q];
        else if(qk > k) return selectK(arr,l,q-1,k);
        else return selectK(arr,q+1,r,k-qk);
    }
    private static int partition(int[] arr,int l,int r){
        //选取l,r,mid 的中间值为主元
        int midIndex = l + ((r - l) >> 1); //中间值的下标
        int midValueIndex = -1;//中值的下标
        //如果 arr[r] < arr[l] <= arr[midIndex] 则中值下标为l
        if(arr[l] <= arr[midIndex] && arr[l] >= arr[r]) {
            midValueIndex = l;
        }
        //如果 arr[l] < arr[r] <= arr[midIndex] 则中值下标为r
        else if(arr[r] <= arr[midIndex] && arr[r] >= arr[l]) {
            midValueIndex = r;
        }
        //否则 中值下标为midIndex
        else {
            midValueIndex = midIndex;
        }
        Util.swap(arr,l,midValueIndex);

        int pivot = arr[l]; //数组的最左侧值作为主元
        int left = l + 1; //扫描指针
        int right = r; // 右侧指针
        while (left <= right){
            while (left <= right && arr[left] <= pivot) left++; //循环结束，left一定指向第一个大于pivot的元素
            while (left <= right && arr[right] > pivot) right--; //循环结束，right一定指向第一个小于等于pivot的元素
            if(left <= right){
                Util.swap(arr,left,right);
            }
        }
        Util.swap(arr,l,right);
        return right;
    }

    public static void main(String[] args) {
       int[] arr = {1,5,6,3,4};
       int sk = selectK(arr,0,arr.length-1,2);
        System.out.println(sk);
    }
}
