package 基础练习;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/20 15:43
 **/

public class 质因数分解 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = a; i <= b; i++) {
            boolean flog = isPrime(i);
            if (flog !=true) { // 如果不是素数，质因数分解
                Map<Integer, Integer> map = primeFactor(i);
                StringBuilder sb = new StringBuilder();
                for (int key : map.keySet()) {
                    int value = map.get(key);
                    for (int j = 0; j < value; j++) {
                        sb.append("*" + key);
                    }
                }
                System.out.println(i + "=" + sb.substring(1));
            } else { //如果是素数，输出它本身
                System.out.println(i + "=" + i);
            }

        }

    }

    /**
     * 质因式分解
     * @param num
     * @return
     */
    private static Map<Integer, Integer> primeFactor(int num) {
        Map<Integer,Integer> map = new HashMap<>(); //key-value 质因数-出现次数
        for (int i = 2; i <= num; i++) {
            while (num % i ==0 ){
                Integer v = map.get(i);
                if (v == null) {
                    map.put(i,1);
                } else { //质因数重复，value值加1
                    map.put(i,v + 1);
                }
                num /= i;
            }
        }
        return map;
    }

    /**
     * 是否为素数
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i ==0) return false;
        }
        return true;
    }
}
