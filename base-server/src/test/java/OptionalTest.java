import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OptionalTest {

    public static void main(String[] args) {
        // new一个 string list
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");

        Optional<List<String>> list = Optional.ofNullable(strList);
        Optional<List<String>> list1 = Optional.of(strList);
//        System.out.println(strs2
//                .filter(s -> s.contains("90"))
//                .orElse("0"));
//        System.out.println(strs2
//                .filter(s -> s.contains("90"))
//                .orElseGet(() -> "null"));\
        System.out.println(strList.stream().filter(s -> NumberUtils.parseNumber(s, Integer.class).intValue() > 2)
                .findFirst().orElseGet(() -> "no no no"));
//        list.stream().filter(new Predicate<List<String>>() {
//            @Override
//            public boolean test(List<String> strings) {
//
//                return false;
//            }
//        })

    }
}
