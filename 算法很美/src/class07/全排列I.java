package class07;

import java.util.ArrayList;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/5/5 17:19
 **/

public class 全排列I {
    public static void main(String[] args) {
        ArrayList<String> res = new 全排列I().getPermutation0("abcde");
        System.out.println(res.size());
        System.out.println(res);
    }
    /**
    逐步生成大发：迭代法
     */
    public ArrayList<String> getPermutation0(String A) {
        int n = A.length();
        ArrayList<String> res = new ArrayList<>();
        res.add(A.charAt(0) + ""); //初始化，包含第一个字符

        for (int i = 1; i < n; i++) { //第二个字符插入到前面生成集合的每个元素里面
            ArrayList<String> res_new = new ArrayList<>();
            char c = A.charAt(i); //新字符
            for (String str : res) { //访问上一趟集合中的每个字符串
                // 插入到每个位置，形成一个新串
                String newStr = c + str; //加在前面
                res_new.add(newStr);
                newStr = str + c; // 加在后面
                res_new.add(newStr);
                // 加在中间
                for(int j = 1; j < str.length(); j++) {
                    newStr = str.substring(0,j) + c + str.substring(j);
                    res_new.add(newStr);
                }

            }
            res = res_new;
        }
        return res;
    }
}
