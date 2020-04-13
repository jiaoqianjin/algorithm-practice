package class05;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author 焦前进
 * @Date: 2020/4/4 16:53
 * @Description:
 **/
public class 回文字符串 {
    public static boolean isPalindrome(String s){
        if(StringUtils.isEmpty(s)){
            return true;
        }
        //翻转后和自己相同
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    // ijji
    public static void palindromeNumber(){
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.println(i*1000+j*100+j*10+i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcddcba"));
        palindromeNumber();
    }
}
