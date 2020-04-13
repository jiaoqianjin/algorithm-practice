package class03.算法案例;

import class02.快速排序;
import util.Util;

/**
 * @Auther: 焦前进
 * @Data:2020/3/23
 * @Description: 合并有序数组
 * 给定排序后的数组A和B ，其中A末端有足够的缓冲空间容纳B,
 * 编写一个方法，将B合并入A 并排序
 */
public class 合并有序数组 {
    /**
     *
     */
    public static int[] mergeArr(int[] A,int[] B){
        int a = A.length-1; //A数组末尾指针
        int b = B.length-1; // B数组末尾指针
        //确定A数组需要扩展的距离，末尾作为当前指针
        int current = a + b + 1;
        A =java.util.Arrays.copyOf(A,current+1);
        //两个数组中的那个大，那个放在最后
        while (b >=0 && a >=0) {
            A[current--] = A[a] > B[b] ? A[a--] : B[b--];
        }
        while (b >=0){
            A[current--] = B[b--];
        }
//        while (a >=0){
//            A[current--] = A[a--];
//        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {10,15,18};
        快速排序.quickSort(A,0,A.length-1);
        Util.printArray(A);
        int[] B = {1,2,5,20};
        快速排序.quickSort(B,0,B.length-1);
        Util.printArray(B);
        Util.printArray(mergeArr(A,B));
    }
}
