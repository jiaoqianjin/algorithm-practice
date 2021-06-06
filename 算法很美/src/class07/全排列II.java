package class07;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/5/6 15:45
 **/

public class 全排列II {
    public static void main(String[] args) {
        ArrayList<String> res = new 全排列II().getPermutation("ab");
        System.out.println(res.size());
        System.out.println(res);
    }
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> getPermutation(String A) {
        char[] arr = A.toCharArray();
        Arrays.sort(arr);
        getPermutationCore(arr,0);
        return res;
    }
    private void getPermutationCore(char[] arr, int k) {
        if(k == arr.length) { // 排好了一种情况，递归的支路就走到底了
            res.add(new String(arr));
        }
        // 从k 为开始的每个字符，都尝试放在新排列的k这个位置
        for(int i = k; i < arr.length; i++) {
            swap(arr,k,i); //把后面的每个字符都换到k位
            getPermutationCore(arr,k + 1);
            swap(arr,k,i);//回溯
        }
    }

    private void swap(char[] arr, int k, int i) {
        char tmp = arr[i];
        arr[i] = arr[k];
        arr[k] = tmp;
    }
}
