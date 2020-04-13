package class05;

/**
 * @Author 焦前进
 * @Date: 2020/4/2 17:33
 * @Description:
 *
 **/
public class 翻转字符串 {
    public static String reverse1(String s){
        int n = s.length();
        char[] charArr = new char[n];
        for (int i = 0; i < n; i++){
            charArr[i] = s.charAt(n - 1 - i);
        }
        return new String(charArr);
    }
    public static String reverse2(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
//    public static int reverse3(int arr){
//        return Integer.reverse(arr);
//    }
    public static void main(String[] args) {
        String s = "i love you";
        System.out.println(reverse1(s));
        System.out.println(reverse2(s));
//        System.out.println(reverse3(43261596));
    }
}
