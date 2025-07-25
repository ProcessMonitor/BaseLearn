
import java.util.*;
import java.util.stream.Collectors;

public class TTest {

    public <T> List<T> test(T data) {
        return List.of();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        int pivotIndex = 2; // 目标位置
        LinkedList<String> beforeList = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i == pivotIndex) {
                break;
            }
            beforeList.add(list.get(i));
        }

        list.removeAll(beforeList);
//        for (int i = 0; i < beforeList.size(); i++) {
//            String pollFirst = beforeList.pollFirst();
//            list.addLast(pollFirst);
//        }
        list.addAll(beforeList);

        System.out.println(list);


        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(e -> Integer.valueOf(e) > 3 ?
                "over 3" : "less 3"));

        System.out.println(map);
    }


}
