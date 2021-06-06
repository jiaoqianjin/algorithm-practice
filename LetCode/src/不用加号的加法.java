/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 11:21
 **/

public class 不用加号的加法 {
    public int add(int a, int b) {
        return Math.addExact(a,b);
    }

    public static void main(String[] args) {
        System.out.println(new 不用加号的加法().add(-5, 2));
    }
}
