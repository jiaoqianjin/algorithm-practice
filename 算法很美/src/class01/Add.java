package class01;

/**
 * @Auther:焦前进
 * @Data:2020/3/4
 * @Description:
 */
public class Add {
    /**
     * 递归利用位运算实现加法运算
     * @param a
     * @param b
     * @return
     */
    private int add(int a,int b){
        if(b == 0){
            return a;
        }else{
            int carry = (a & b)<<1;
            a = a^b;
            return add(a,carry);
        }
    }

    /**
     * 非递归实现利用位运算实现加法
     * @param a
     * @param b
     * @return
     */
    private int add1(int a,int b){
        int carry;
        while (b != 0){
            carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    /**
     * 实现加法运算
     * @param a
     * @param b
     * @return
     */
    private int subtraction(int a,int b){
        b = ~b + 1;
        return add(a,b);
    }
    int multiply(int a, int b) {
        //将乘数和被乘数都取绝对值　
        int multiplicand = a < 0 ? add(~a, 1) : a;
        int multiplier = b < 0 ? add(~b , 1) : b;
        //计算绝对值的乘积　　
        int product = 0;
        while(multiplier > 0) {
            if((multiplier & 0x1) > 0) {// 每次考察乘数的最后一位　　　　
                product = add(product, multiplicand);
                System.out.println(Integer.toString(multiplicand,2));
            }
            multiplicand = multiplicand << 1;// 每运算一次，被乘数要左移一位　　　　
            multiplier = multiplier >> 1;// 每运算一次，乘数要右移一位（可对照上图理解）　　
        }
        //计算乘积的符号　　
        if((a ^ b) < 0) {
            product = add(~product, 1);
        }
        return product;
    }
    int multiply1(int a,int b){
        //将乘数和被乘数都去绝对值
        int multiplicand = a < 0 ? add (~a,1) : a;
        int multiplier = b < 0 ? add (~b,1) : b;
        //计算乘积
        int product = 0;
        while(multiplier > 0){
            if((multiplier & 1)== 1){//判断最后一位是否为1
                product = add(product,multiplicand);
            }
            multiplicand = multiplicand << 1; //乘数左移
            multiplier = multiplier >> 1;   //被乘数右移
        }
        // 计算乘积结果的符号；
        if((a^b) < 0){
            product = add (~product,1);
        }
        return product;
    }

    public static void main(String[] args) {
        Add A = new Add();
        System.out.println(A.add(13,9));
        System.out.println(A.add1(15,9));
        System.out.println(A.subtraction(15,9));
        System.out.println("何紫薇是小狗");
        System.out.println(A.multiply(3,5));
        System.out.println(A.multiply1(3,5));
    }
}
