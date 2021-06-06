package class07;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：
 * 实现以中国算法，打印 n 对括号的全部有效组合（即左右括号正确配对
 * 示例
 * 输入： 3
 * 输出：()()(), (()()), ()(()), (())(), ((()))
 *
 * @author jiaoqianjin
 * Date: 2020/10/8 21:29
 **/

public class 合法括号 {
    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static Set<String> solve1(int n) {
        Set<String> set = new HashSet<>();
        if (n == 1) {
            set.add("()");
            return set;
        }
        Set<String> set1 = solve1(n - 1);
        for (String res : set1) {
            set.add(res + "()");
            set.add("(" + res + ")");
            set.add("()" + res);
        }
        return set;
    }

    /**
     * 迭代
     *
     * @param n
     * @return
     */
    public static Set<String> solve2(int n) {
        // 保存上次迭代的状态
        Set<String> set = new HashSet<>();
        set.add("()");
        if (n == 1) {
            return set;
        }
        for (int i = 2; i <= n; i++) {
            Set<String> set1 = new HashSet<>();
            for (String res : set) {
                set1.add(res + "()");
                set1.add("(" + res + ")");
                set1.add("()" + res);
            }
            set = set1;
        }
        System.out.println(set.size());
        return set;
    }
    public static void main(String[] args) {
        System.out.println(solve2(4));
        System.out.println(solve1(4));
        System.out.println(solve1(3).size());
    }
}
