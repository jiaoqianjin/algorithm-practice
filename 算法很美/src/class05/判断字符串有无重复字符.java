package class05;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author 焦前进
 * @Date: 2020/4/2 17:06
 * @Description:
 **/
public class 判断字符串有无重复字符 {
    public static boolean checkDifferent(String iniString){
        if(StringUtils.isEmpty(iniString)){
            return true;
        }
        int[] flag = new int[128];
        //扫描字符串
        for (int i = 0; i < iniString.length(); i++){
            int c = iniString.charAt(i);
            if (flag[c] > 0){
                return false;
            }else {
                flag[c]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String iniString = "acdiuah";
        System.out.println(checkDifferent(iniString));
    }
}
