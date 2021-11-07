package leetcode.hash;

import java.util.*;

/**
 * Description： 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/7/10 14:14
 **/

public class LetterCombinations {

    private List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>(8) {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jki");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        backtrack(res, map, digits, 0, new StringBuffer());

        return res;
    }

    private void backtrack(List<String> res, Map<Character, String> map, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            res.add(stringBuffer.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                stringBuffer.append(letters.charAt(i));
                backtrack(res, map, digits, index + 1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }


//     for (int i = 0; i < digits.length(); i++) {
//        Integer current = null;
//        if (digits.charAt(i) >= 48 && digits.charAt(i) <= 57) {
//            current = Integer.parseInt(String.valueOf(digits.charAt(i)));
//        }
//        String str = map.get(current);
//
//        if (str != null) {
//            for (int j = 0; j < str.length(); j++) {
//                if (str.length() == 1) {
//                    res.add(String.valueOf(str.indexOf(j)));
//                }
//                for (int m = 0; m < str.length(); m++) {
//                    if (str.length() == 2) {
//                        res.add(String.valueOf(str.charAt(j)));
//                    }
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        Scanner sc = new Scanner(System.in);
        String digits = sc.next();
        System.out.println(letterCombinations.letterCombinations(digits));
    }
}
