package 基础练习;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/15 17:17
 **/

public class 字符串01 {
    public static void main(String[] args) {
        for(int i = 0; i < 32; i++){
            String res = Integer.toString(i,2);
            while (res.length() < 5){
                res = "0" + res;
            }
            System.out.println(res);
        }

    }
}
