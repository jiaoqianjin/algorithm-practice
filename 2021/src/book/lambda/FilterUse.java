package book.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Description：Filter & Predicate
 *
 * @author jiaoqianjin
 * Date: 2021/12/15 19:34
 **/

public class FilterUse {
    public static void main(String args[]) {
        List<String> names = Arrays.asList("张三丰", "张翠山", "张无忌", "金毛狮王", "赵敏");

        // 张开头的
        Predicate<String> zhang = (n) -> n.startsWith("张"); //
        // 含三丰的
        Predicate<String> sanfeng = (n) -> n.contains("三丰");
        // 王结尾的
        Predicate<String> wang = (n) -> n.endsWith("王");
        sanfeng.equals("金毛");

        //Predicate常和stream的filter配合使用，实现过滤
        //和filter结合用 默认调用的是test()方法 姓张的
        names.stream().filter(zhang).forEach(n -> System.out.println(n));

        //and()  姓张的，含三丰的
        names.stream().filter(zhang.and(sanfeng)).forEach(n -> System.out.println(n));

        //or()  张开头的,或者 王结尾的
        names.stream().filter(zhang.or(wang)).forEach(n -> System.out.println(n));

        //negate() 不是张开头的，但是王结尾的
        names.stream().filter(zhang.negate().and(wang)).forEach(n -> System.out.println(n));

        // equals() 方法还没懂什么意思

//        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        double bill = costBeforeTax.stream().map((cost) -> cost+1).reduce((sum, cost) -> sum + cost).get();
//        System.out.println("Total : " + bill);
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

    }
}
