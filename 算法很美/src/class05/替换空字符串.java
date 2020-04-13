package class05;

/**
 * @Author 焦前进
 * @Date: 2020/4/4 14:32
 * @Description:
 *  请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
 *  并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 *  给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 *  测试样例：
 *  "Mr John Smith”,13
 *  返回："Mr%20John%20Smith"
 *  ”Hello  World”,12
 *  返回：”Hello%20%20World”
 **/
public class 替换空字符串 {
    public static String replaceSpace(String iniString){
        return iniString.replaceAll("\\s","%20");
    }
    public static String replaceSpace(char[] iniString,int length){
        int count = length;
        for (int i = 0; i < length; i++){
            if(iniString[i] ==' '){
                count += 2;
            }
        }
        int p1 = length - 1,p2 = count - 1;
        while (p1 >= 0){
            if(iniString[p1] == ' '){
                iniString[p2 --] = '0';
                iniString[p2 --] = '2';
                iniString[p2 --] = '%';
            }else {
                iniString[p2--] = iniString[p1];
            }
            p1 --;
        }
        return new String(iniString, 0, count);
    }
    public static void main(String[] args) {
        String s = "I love you";
        System.out.println(replaceSpace(s));
        System.out.println(replaceSpace("Mr John Smith000000000000000000000".toCharArray(), 13));
    }
}
