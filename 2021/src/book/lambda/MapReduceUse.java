package book.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/16 9:59
 **/

public class MapReduceUse {
    public void test(){
        List list = new ArrayList<>(10);
        list.add(new Student("“刘一”", 85));
        list.add(new Student("“陈二”", 90));
        list.add(new Student("“张三”", 98));
        list.add(new Student("“李四”", 88));
        list.add(new Student("“王五”", 83));
        list.add(new Student("“赵六”", 95));
        list.add(new Student("“孙七”", 87));
        list.add(new Student("“周八”", 84));
        list.add(new Student("“吴九”", 100));
        list.add(new Student("“郑十”", 95));

        //使用map方法获取list数据中的name
//        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
//        System.out.println(names);


    }
    public static void main(String[] args) {
        MapReduceUse mapReduceUse = new MapReduceUse();
        mapReduceUse.test();
    }

}
