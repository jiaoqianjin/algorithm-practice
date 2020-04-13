package class05;

/**
 * @Author 焦前进
 * @Date: 2020/4/4 15:33
 * @Description:
 **/
public class 判断A串是否B串的旋转字符串 {
    public static boolean isRotate(String a,String b){
        if(a.length()!=b.length()){
            return false;
        }
        StringBuilder sb = new StringBuilder(b).append(b);
        return sb.toString().contains(a);
    }
    public static void main(String[] args) {
        System.out.println(isRotate("defabd", "fabdde"));
        System.out.println(isRotate("abc", "cba"));
    }
}
