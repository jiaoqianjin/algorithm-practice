import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/24
 * @Description:
 */
public class 最小的K个数 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        util.printArray(getLeastNumbers(arr,3));
    }
}
