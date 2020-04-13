package class05;

import util.Util;

import static java.util.Objects.hash;

/**
 * @Author 焦前进
 * @Date: 2020/4/6 15:19
 * @Description:
 *  * 滚动hash法
 *  * 对目标字符串按d进制求值,mod h 取余作为其hash
 *  * 对源串,依次求出m个字符的hash,保存在数组中(滚动计算)
 *  * 匹配时,只需比对目标串的hash值和预存的源串的hash值表
 **/
public class 匹配字符串 {
    public static void main(String[] args) {
        String s = "ABABABA";
        String p = "ABA";
        match(p, s);
    }

    /**
     *
     * @param p 模式
     * @param s 原串
     */
//    private static void match(String p, String s) {
//        long hash_p = hash(p); //p 的 hash 值
//        int p_len = p.length();
//        for(int i = 0; i + p_len <= s.length(); i++){
//            long hash_i = hash(s.substring(i,i+p_len)); //i为起点，长度为 p_len 子串的额hashzhi
//            if(hash_i == hash_p){
//                System.out.println("match:" + i);
//            }
//        }
//    }
    final static long seed = 31;
    /**
     * 使用100000个不同字符串产生的冲突数，大概在0~3波动，使用100百万不同的字符串，冲突数大概110+范围波动。
     * @param str
     * @return
     */
    static long hash(String str) {
        long h = 0;
        for (int i = 0; i != str.length(); ++i) {
            h = seed * h + str.charAt(i);
        }
        return h % Long.MAX_VALUE;
    }
    private static void match(String p, String s) {
        long hash_p = hash(p); //p的hash 值
        long[] hashOfs = hash(s,p.length());
        match(hash_p,hashOfs);
    }
    private static void match(long hash_p, long[] hash_s) {
        for (int i = 0; i < hash_s.length; i++) {
            if (hash_s[i] == hash_p) {
                System.out.println("match:" + i);
            }
        }
    }
    /**
     * n 是子串的长度
     * 用滚动的方法求出s 中长度为 n 的每个子串的 hash,组成一个hash数组
     * @param s
     * @param n
     * @return
     */
    public static long[] hash(final String s,final int n){
        long[] res = new long[s.length() - n + 1];
        //前 m 个字符的 hash
        res[0] = hash(s.substring(0,n));
        for (int i = n; i < s.length(); i++){
            char newChar = s.charAt(i);
            char oChar = s.charAt(i - n);
            //前 n 个字符的hash*seed - 前 n 字符的第一字符*sees 的 n次方
            long v = (res[i - n] * seed + newChar - Util.ex2(seed, n) * oChar) % Long.MAX_VALUE;
            res[i - n + 1] = v;
        }
        return res;
    }

    /**
     * 暴力破解
     * @param s
     * @param p
     * @return
     */
    private static int indexOf(String s,String p){
        int i = 0;
        int sc = i;
        int j = 0;
        while (sc < s.length()){
            if(s.charAt(sc) == p.charAt(j)){
                sc++;
                j++;
                if(j == p.length()){
                    return i;
                }
            }else {
                i++;
                sc = i;
                j = 0;
            }
        }
        return -1;
    }
}
