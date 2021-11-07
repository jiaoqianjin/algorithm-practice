package sort;

/**
 * @Author 焦前进
 * @Date: 2020/3/25 15:13
 * @Description:
 **/
public class TreeSort {
    public static void minHeap(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapFixDown(A, i, n);
        }
    }

    public static void minHeapFixDown(int[] A, int i, int n) {
        //找到左右孩子
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 左孩子越界，i 就是叶子节点，返回
        if (left >= n) {
            return;
        }
        int min = left;
        // 右孩子越界，最小值为左孩子
        if (right >= n) {
            min = left;
        } else { //都没有越界，如果右孩子比左孩子小，那最小值为右孩子
            if (A[right] < A[left]) {
                min = right;
            }
        }
        //如果A[i]比两个孩子小，不用调整
        if (A[i] < A[min]) {
            return;
        }
        //否则，那个孩子小，那个和i 交换
        swap(A, i, min);
        //哪个孩子发生了变化，继续递归调整，直到子节点
        minHeapFixDown(A, min, n);
    }

    /**
     * 小根堆对数组排序
     *
     * @param A
     */
    public static void minHeapSort(int[] A) {
        //先对A进行堆化
        minHeap(A);
        for (int x = A.length - 1; x > 0; x--) {
            //把堆顶和最后一个元素交换
            swap(A, 0, x);
            //缩小堆的范围，对堆顶元素进行向下调整
            minHeapFixDown(A, 0, x);
        }
    }

    /**
     * 交换 arr 中 下标 i ，j 元素
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对数组进行遍历输出
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {35, 10, 26, 1, 15, 13, 28};
        minHeapSort(arr);
        printArray(arr);
    }
}
