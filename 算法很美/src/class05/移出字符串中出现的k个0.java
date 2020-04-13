package class05;

/**
 * @Author 焦前进
 * @Date: 2020/4/4 16:23
 * @Description:
 * * 移除字符串中连续出现的K个0
 *  *
 *  * 可以用扫描字符数组的解法，但是用正则表达式更为快捷
 **/
public class 移出字符串中出现的k个0 {
    public static String remove(String iniString,int k  ){
        String regexp = "0{"+ k +"}";
        return iniString.replaceAll(regexp,"");
    }
    public static String remove2(String iniString,int k){
//        char[] arr = iniString.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iniString.length(); i++){
            char c = iniString.charAt(i);
            if(c == '0'){
                count++;
            }else {
                for (int j = 0; j < count % k; j++){
                    sb.append('0');
                }
                sb.append(c);
                count = 0;
            }
        }
        for (int j = 0; j < count % k; j++) {
            sb.append('0');
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "a0002dfdfd";
        System.out.println(remove(s,2));
        System.out.println(remove2(s,2));
    }
}
