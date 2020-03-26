package class01;

/**
 * @Auther:焦前进
 * @Data:2020/3/4
 * @Description:
 *          0-1 之间浮点实数的二进制表示
 *  给定一个介于0和1之间的实数，（如0.625）类型为double
 *  打印它的二进制表示(0.101)
 *  因为小数点后的二进制分别表示0.5，,025,0.125
 *
 *  如果该小数无法精确地用32位以内的二进制表示，则打印“error"
 *
 */
public class 二进制小数 {
    public static void main(String[] args) {
        double num = 0.625;
        StringBuilder sb = new StringBuilder("0.");
        while (num > 0){
            //乘 2 ，挪整
            double r = num *2;
            if (r >= 1){
                num = r -1 ;
                sb.append("1");
            }else {
                sb.append("0");
                num = r;
            }
            if (sb.length() > 32){
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
