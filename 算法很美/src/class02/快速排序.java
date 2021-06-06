package class02;

import util.Util;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/17
 * @Description:
 */
public class 快速排序 {

    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition2(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    /**
     * 方法一：单向扫描
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private static int partition1(int[] arr, int p, int r) {
        int pivot = arr[p];
        int sp = p + 1; //扫描指针
        int bigger = r; //右侧指针
        while (sp <= bigger) {
            if (arr[sp] <= pivot) { //扫描元素小于主元，左指针右移
                sp++;
            } else { //扫描元素大于主元，二指针元素交换，右指针左移
                swap(arr, sp, bigger);
                bigger--;
            }
        }
        swap(arr, p, bigger);
        return bigger;
    }

    /**
     * 方法二：双向扫描
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public static int partition2(int[] arr,int p,int r){
        //优化，在P，r,mid之间，选一个中间值作为主元
        int midIndex = p + ((r - p) >> 1); //中间下标
        int midValueIndex = -1 ; //中值下标
        if(arr[p] <= arr[midIndex]&&arr[p] >= arr[r]){
            midValueIndex = p;
        } else if(arr[r] <= arr[midIndex]&&arr[r] >= arr[p]){
            midValueIndex = r;
        }else {
            midValueIndex = midIndex;
        }
        swap(arr,p,midValueIndex);
        int pivot = arr[p];
        int left = p + 1; //扫描指针
        int right = r; //右侧指针
        while (left <= right){
            //left不停的往右走，直到遇到大于主元的元素
            while (left <= right && arr[left] <= pivot) left++;//循环退出时，left一定指向第一个大于主元的元素
            while (left <= right && pivot < arr[right]) right--;//循环退出时，right一定指向第一个小于主元的元素
            if(left<=right){
                swap(arr,left,right);
            }
        }
        //while退出时，两者交错，right一定指向第一个小于主元的元素
        swap(arr, p, right);
        return right;
    }

    /**
     * 方法三：三分法
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private static int partition3(int[] arr, int p, int r) {
        int pivot = arr[r];
       int less = p - 1;
       int more = r;
       int cur = p;
       while (cur < more){
           if(arr[cur] < pivot){ //当前值小于目标值
               less ++;
               swap(arr,less,cur);
               cur ++;
           }else if (arr[cur] > pivot){ //当前值大于目标值
               more --;
               swap(arr,more,cur);
           }else {
               cur ++;
           }
       }
       swap(arr,more,r); //more此时为第一个大于目标值的坐标
       return cur;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,6,4,8,9,3,10,2,5,8,0,1,5,9,4,8,6};
        printArray(arr);
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
