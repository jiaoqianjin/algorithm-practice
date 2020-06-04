package 算法训练;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description：
 * 给定一个长度为n的字符串S，还有一个数字L，
 * 统计长度大于等于L的出现次数最多的子串（不同的出现可以相交），
 * 如果有多个，输出最长的，如果仍然有多个，输出第一次出现最早的。
 *
 *
 * 解题思路。利用ASCII码，将字符对应的数字 作为数组的下标，出现一次下标对应的数字加1
 *
 * @author jiaoqianjin
 * Date: 2020/6/1 15:40
 **/

public class 字串统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();

        Map<String,Integer> map = new HashMap<String, Integer>();
        int maxValue = 0;
        String maxString = "";

        for (int i = 0; i < str.length() - L + 1; i++) {
            for(int j = i + L; j < str.length(); j ++) {
                String s = str.substring(i,j);
                if(map.containsKey(s)){   //若该字符串之前出现过则map(key,value)中value值+1
                    int value = map.get(s) ;
                    value ++ ;
                    if(value > maxValue){
                        maxValue = value ;
                        maxString = s ;
                    }else if(value == maxValue){    //若该字符串出现的次数与当前出现次数最多的字符串相等，则比较两个字符串的长度，取字符串长的
                        if(maxString.length() < s.length()){
                            maxString = s ;
                        }
                    }
                    map.put(s, value) ;
                }else{  //若该字符串之前并未出现过则添加，并初始化value值为0
                    map.put(s, 0) ;
                }
            }
        }
        System.out.println(maxString);
    }
}
