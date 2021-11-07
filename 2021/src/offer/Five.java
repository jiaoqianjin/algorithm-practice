package offer;

/**
 * Description：替换空格
 * 请实现一个函数，把字符串中的每个空格都替换成“%20”。例如：
 * 输入“We are happy”,则输出“We%20are%20happy”
 *
 * @author jiaoqianjin
 * Date: 2021/9/11 11:03
 **/

public class Five {
    /**
     * 功能描述: 解题思路
     * 1.遍历一遍字符串，统计字符串空格的总数
     * 2.重新计算字符串的总长度，原长+2*空格的总数
     * 3.从字符串后面开始复制和替换
     * 4.准备两个指针：P1指向原始字符串的末尾，P2指向替换后字符串的末尾
     * 5.遇到空格，P1移动1，P2移动3
     *
     * @param target 目标字符串
     * @return 替换后的字符串
     * @author jiaoqianjin
     * @date 2021/9/11
     */
    private String replaceBlank(String target) {
        if (target == null || "".equals(target)) {
            return null;
        }
        int strLength = target.length();
        int numBlank = 0;
        char[] chars = target.toCharArray();
        for (int i = 0; i < strLength; i++) {
            if (chars[i] == ' ') {
                numBlank++;
            }
        }
        // 新字符串的长度
        int newLength = chars.length + 2 * numBlank;
        if (newLength == strLength) {
            return target;
        }
        // 声明新数组
        char[] res = new char[newLength];

        int indexOfOriginal = target.length() - 1;
        int indexOfNew = newLength - 1;

        while (indexOfOriginal>=0 && indexOfNew >= indexOfOriginal) {
            if (chars[indexOfOriginal] == ' ') {
                res[indexOfNew--] = '0';
                res[indexOfNew--] = '2';
                res[indexOfNew--] = '%';
            } else {
                res[indexOfNew--] = chars[indexOfOriginal];
            }
            indexOfOriginal --;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Five five = new Five();
        String s = "We are happy";
        System.out.println(five.replaceBlank(s));
    }
}
