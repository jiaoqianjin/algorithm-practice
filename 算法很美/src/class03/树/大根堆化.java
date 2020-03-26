package class03.树;

import class03.util;

/**
 * @Author 焦前进
 * @Date: 2020/3/25 15:54
 * @Description:
 **/
public class 大根堆化 {
    public static void maxHeap(int[] A){
        int n = A.length;
        for (int i = n / 2 - 1;i >=0;i--){
            maxHeapFixUp(A,i,n);
        }
    }

    private static void maxHeapFixUp(int[] A, int i, int n) {
        //找出左右子树
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        //如果左子树越界，则该节点为叶子节点
        if(left >= n){
            return;
        }
        int max = left; //默认左子树为最大值
        //如果右子树越界，则左子树为最大值
        if(right >= n){
            max = left;
        }else{ //左右子树都不越界，判断大小
            if(A[right] > A[left]){
                max = right;
            }
        }
        //如果根节点最大，则返回
        if(A[i] > A[max]){
            return;
        }
        //否则，最大值与 i 交换
        util.swap(A, max, i);
        //那个子树发生变化，与 i 交换后，继续递归调整，直到叶子节点
        maxHeapFixUp(A, max, n);
    }
    public static void maxHeapSort(int[] A){
        //堆化
        maxHeap(A);
        for(int x = A.length - 1 ; x > 0 ;x--){
            //最后一个元素和 根节点交换，
            util.swap(A,0,x);
            //缩小堆的范围,对堆进行向下调整
            maxHeapFixUp(A,0,x);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,1,13,15,18};
        maxHeap(arr);
        util.printArray(arr);
        maxHeapSort(arr);
        util.printArray(arr);
    }
}
