package class07;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/9 21:58
 **/

public class 全排列II_n {
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> getPermutation(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        permutation(c, 0);
        return res;
    }

    private ArrayList<String> permutation(char[] c, int k) {
        if (k == c.length) {
            res.add(new String(c));
        }
        for (int i = k; i < c.length; i++) {
            Util.swap(c, k, i);
            permutation(c, k + 1);
            // 回溯
            Util.swap(c, k, i);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> res = new 全排列II_n().getPermutation("aab");
        Set<String> set = new HashSet<>(res);

        System.out.println(res);
        System.out.println(set);
    }
}
