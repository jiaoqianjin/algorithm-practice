import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 10:46
 **/

public class 至少有K个重复字符的最长子串 {
    public int longestSubstring(String s, int k) {
        char[] flag = new char[128];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            flag[c]++;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] >= k) {
                sum += flag[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "ababacb";
        System.out.println(new 至少有K个重复字符的最长子串().longestSubstring(s, 3));
    }
}
