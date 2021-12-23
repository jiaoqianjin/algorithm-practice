package book.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/12/16 19:42
 **/

public class ComparatorUse {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.stream().sorted(String::compareTo);
    }
}
