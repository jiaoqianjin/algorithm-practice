package class06;

/**
 * @Author 焦前进
 * @Date: 2020/4/8 14:53
 * @Description:
 **/
public class Nim {
    public static void main(String[] args) {
        int[] A = {5,10,15};
        boolean res = solve(A);
        System.out.println(res);
    }
    private static boolean solve(int[] A){
        int res = 0;
        for(int i = 0; i <A.length; i++){
            res ^= A[i];
        }
        return res != 0; // 拿一个之后 剩下的异或 为0 就赢了 ；

    }
}
