package class07;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/5/6 16:27
 **/

public class 全排列III {
    public static void main(String[] args) {
        String s = "123";
        permutation("",s.toCharArray());
    }
    final static int k = 3;
    static int count = 0;

    private static void permutation(String prefix,char[] arr) {
        if(prefix.length() == arr.length) {
            count ++;
            if(count == k) {
                System.out.println("----------:" + prefix);
                System.exit(0);
            }
        }
        //每次都从头扫描，只要该字符可用，我们就附加到前缀后面，前缀变长了
        for(int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            // 这个字符可用：在pre中出现次数<在字符集中的出现次数
//            if (count(prefix, ch) < count(arr,ch)) {
//                permutation(prefix + ch,arr);
//            }
        }
    }
}
