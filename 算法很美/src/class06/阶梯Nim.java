package class06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 焦前进
 * @Date: 2020/4/9 15:07
 * @Description:
 **/
public class 阶梯Nim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextByte();
        int arr[] = new int[num];
        for(int i = 0 ; i < num; i++){
            arr[i] = sc.nextInt();
        }
        int res = 0;
        Arrays.sort(arr); //排练 不然殊勋会乱
        if((num&1) == 1) { //num 为奇数
            for(int i = 0 ; i < arr.length; i += 2) {
                res ^= i == 0 ? (arr[0] - 1) : (arr[i] - arr[i-1] - 1);
            }

        }else {// num 为偶数
            for(int i = 1 ; i < arr.length; i += 2) {
                res ^= (arr[i] - arr[i-1] - 1);
            }
        }
        if(res == 0){
            System.out.println("先手会输");
        }else{
            System.out.println("先手会赢");
        }
    }
}
