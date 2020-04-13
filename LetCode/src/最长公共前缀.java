import java.util.Arrays;

/**
 * @Author 焦前进
 * @Date: 2020/4/6 17:10
 * @Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class 最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        return commonString(strs);
    }

    private static String commonString(String[] strs){
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            res = getCommon(res,strs[i]);
        }
        if(res.isEmpty()){
            return "";
        }
        return res;
    }

    private static String getCommon(String res, String str) {
        int len = res.length() < str.length() ? res.length() : str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len ; i++){
            if(res.charAt(0) == str.charAt(0)&&res.charAt(i) == str.charAt(i)){
                sb.append(res.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = {};
        System.out.println(longestCommonPrefix(s));
    }
}
