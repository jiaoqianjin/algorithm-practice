package class01;

import com.sun.javafx.webkit.UtilitiesImpl;
import sun.applet.Main;

import java.util.Random;

/**
 * @Auther:焦前进
 * @Data:2020/3/2
 * @Description:
 * 1-1000 这一千个数放在含有1001个元素的数组中，只要唯一的一个元素值重复，其他均出现一次，
 * 每个数组元素只能访问一次，设计一个算法，将它找出来；不使用辅助空间
 */
public class 找出唯一成对的数 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,5,6,7,8};

        int x1 = arr[arr.length-1];
        for (int i =1; i<=arr.length-1;i++){
            x1 = (x1^i);
        }
        System.out.println(x1);
        for (int i =0; i<arr.length;i++){
            x1 = x1^arr[i];
            System.out.println(x1);
        }

        System.out.println("===开额外空间==");
        int[] help = new int[arr.length];
        for(int i =0; i < arr.length; i++){
            // 疑问
            help[arr[i]]++;
        }
        for(int i =0; i < arr.length; i++){
           if (help[i] == 2){
               System.out.println(i);
           }
        }


    }
}
