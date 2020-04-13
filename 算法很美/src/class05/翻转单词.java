package class05;

/**
 * @Author 焦前进
 * @Date: 2020/4/4 15:40
 * @Description:
 **/
public class 翻转单词 {
    public static String wordReverse(String s){
        String res = reverse(s); //将字符串整体翻转
        String[] words = res.split("\\s"); //将单词切割
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            sb.append(reverse(words[i]) + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "String index out of range";
        System.out.println(wordReverse(s));
    }
}
