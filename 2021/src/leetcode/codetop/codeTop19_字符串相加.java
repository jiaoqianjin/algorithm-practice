package leetcode.codetop;

/**
 * Description：字符串相加
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/12/10 13:45
 **/

public class codeTop19_字符串相加 {
    /**
     * 功能描述: 解题思路
     * 相同位相加超过十进位
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return java.lang.String
     * @author jiaoqianjin
     * @date 2021/12/10
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int len1 = num1.length() - 1, len2 = num2.length() - 1, carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int a = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int b = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int temp = a + b + carry;
            carry = temp / 10;
            res.append(temp % 10);
            len1--;
            len2--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        codeTop19_字符串相加 test = new codeTop19_字符串相加();
        String num1 = "123";
        String num2 = "49";
        System.out.println(test.addStrings(num1, num2));
    }
}
