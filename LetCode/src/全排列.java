import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * @author jiaoqianjin
 * Date: 2020/10/10 9:06
 **/

public class 全排列 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        getPermute(list1, 0);
        return list;
    }

    private void getPermute(List<Integer> list1, Integer k) {

        if (k == list1.size()) {
            List<Integer> res = new ArrayList<>(list1);
            list.add(res);
        }
        for (Integer i = k; i < list1.size(); i++) {
            swap(list1, k, i);
            getPermute(list1, k + 1);
            swap(list1, k, i);
        }
    }

    private void swap(List<Integer> list1, int k, int i) {
        Integer tamp = list1.get(k);
        list1.set(k, list1.get(i));
        list1.set(i, tamp);
    }

    public static void main(String[] args) {
        int[] num = {1,2,3};
        System.out.println(new 全排列().permute(num));
    }
}
