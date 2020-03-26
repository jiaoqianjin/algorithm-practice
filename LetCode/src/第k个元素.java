
/**
 * 功能描述：算法——第k个元素
 * 以尽量高的效率求出一个乱序数组中按数值顺序的第k个元素的值
 *
 * @author RenShiWei
 * Date: 2020/3/24 15:02
 **/
public class 第k个元素 {

    static int selectK ( int[] arr, int l, int r, int k ) {
//        System.out.println(1);
        //主元的下标
        int q = partition2(arr, l, r);
        //主元是第几个元素
        int qK = q - l + 1;
        if (qK == k) {
            return arr[q];
        } else if (qK > k) {
            return selectK(arr, l, q - 1, k);
        } else {
            return selectK(arr, q + 1, r, k - qK);
        }
    }

    private static int partition2 ( int[] arr, int l, int r ) {
//        System.out.println(2);
        //以第一个元素为主元
        int pivot = arr[l];
        //扫描指针
        int less  = l + 1;
        //右侧指针
        int right = r;
        while (less  <= right) {
//            System.out.println(3);
            while (less  <= right && arr[less ] <= pivot) less ++; //循环结束，left一定指向第一个大于pivot的元素
            while (less  <= right && arr[right] > pivot) right--; //循环结束，right一定指向第一个小于等于pivot的元素
            if(less  <= right){
                swap(arr,less ,right);
            }
        }
        swap(arr, l, right);
        return right;
    }

    public static void swap ( int[] arr, int i, int j ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main ( String[] args ) {
        int[] arr = {5, 6, 8, 4, 3, 55, 9};
        System.out.println("第k个元素");
        int k = selectK(arr, 0, arr.length - 1, 2);
        System.out.println(k);
    }

}

