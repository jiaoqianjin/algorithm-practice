package class05;

/**
 * @Author 焦前进
 * @Date: 2020/4/4 14:54
 * @Description:
 *  利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 *  比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 *  若压缩后的字符串没有变短，则返回原先的字符串。
 *  给定一个string iniString为待压缩的串(长度小于等于10000)，
 *  保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 * 测试样例
 * "aabcccccaaa"
 * 返回："a2b1c5a3"
 **/
public class 压缩字符串 {
    public static String zipString(String src){
        int count = 0; //记录形同字符串出现的次数
        char last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length(); i++){
            char s = src.charAt(i);
            //处理第一个字符
            if(sb.length() == 0){
                sb.append(s);
                count++;
            }else {
                if (s == last){ //和上一个字符相同
                    count++;
                }else {
                    sb.append(count).append(s); //和上一个字符不同
                    count = 1; //重置
                }
            }
            last = s;
        }
        if(count >= 1){ //处理
            sb.append(count);
        }
        //比较新字符串和原字符串
        if (sb.length() >= src.length()) {
            return src;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaaafffffefefefefefeeeeeeeeeee";
        System.out.println(zipString(s));
    }
}
