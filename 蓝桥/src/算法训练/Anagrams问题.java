package 算法训练;

import java.util.Scanner;

/**
 * Description：
 *      Anagrams指的是具有如下特性的两个单词：在这两个单词当中，每一个英文字母（不区分大小写）所出现的次数都是相同的。
 *      例如，“Unclear”和“Nuclear”、“Rimon”和“MinOR”都是Anagrams。
 *      编写一个程序，输入两个单词，然后判断一下，这两个单词是否是Anagrams。每一个单词的长度不会超过80个字符，而且是大小写无关的。
 * 　　输入格式：输入有两行，分别为两个单词。
 * 　　输出格式：输出只有一个字母Y或N，分别表示Yes和No。
 * 　　输入输出样例
 *
 * @author jiaoqianjin
 * Date: 2020/5/28 15:14
 **/

public class Anagrams问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next().toLowerCase(); // 将输入单词全部转换为小写
        String word2 = sc.next().toLowerCase();
        String res = judge(word1,word2);
        System.out.println(res);
    }

    private static String judge(String word1, String word2) {
        int[] helper = new int[128];  // 辅助数组，存储单词对应ASCII对应数字
        if (word1.length() != word2.length()) {  // 单词长度不同，直接返回 N
            return "N";
        }
        for (int i = 0; i < word1.length(); i++) {
            char a = word1.charAt(i);
            helper[a] += 1;  //对应辅助数组指针位置数 +1
            char b = word2.charAt(i);
            helper[b] -= 1;  // 对应辅助数组指针位置数 -1
        }
        for (int i = 0; i < helper.length; i++) { // 扫描数组
            if(helper[i] != 0) {
                return "N";
            }
        }
        return "Y";
    }
}
