package class04;

/**
 * @Author 焦前进
 * @Date: 2020/3/31 16:24
 * @Description:
 **/
public class 之字形打印二维数组 {
    public static void printMatrixZigZag(int[][] matrix){
        int aR = 0; //A 点的行
        int aC = 0; //A 点的列,A 先向右移动，后向下移动
        int bR = 0; //A 点的行
        int bC = 0; //A 点的列，B 先向下移动，后向右移动
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean formUp = false; //判断是左上还是右下
        while (aR != endR + 1){
            printLevel(matrix,aR,aC,bR,bC,formUp);
            //判断 A 点 是否向右移动到最后一列 ，不是，行不变；是行下移
            aR = aC == endC ? aR + 1 : aR;
            //判断 A 点 列方向是否向右移动到最后一列 ，不是，列右移；是，列不变
            aC = aC == endC ? aC : aC + 1;
            //判断 B 点 是否向下移动到最后一行 ，不是，列不变；是，列右移
            bC = bR == endR ? bC + 1 : bC;
            //判断B 点 是否向下移动到最后一行 ，不是，行下移；是，行不变
            bR = bR == endR ? bR : bR + 1;
            formUp = !formUp;
            System.out.println();
        }
    }

    private static void printLevel(int[][] matrix, int aR, int aC, int bR, int bC, boolean formUp) {
        if(formUp){
            while (aR != bR + 1){
                System.out.print(matrix[aR++][aC--] + " ");
            }
        }else {
            while (bR != aR - 1){
                System.out.print(matrix[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        printMatrixZigZag(matrix);
    }
}
