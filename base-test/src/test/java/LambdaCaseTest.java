import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class LambdaCaseTest {

    static List<Integer> myFilter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            // 条件以后需要变
            if (predicate.test(integer)) {
                result.add(integer);
            }
        }
        return result;
    }

    static List<String> myMap(List<Integer> list, Function<Integer, String> function) {
        List<String> result = new ArrayList<>();
        for (Integer number : list) {
            // 现在是数字转换为字符串  条件以后需要变
            result.add(function.apply(number));
        }
        return result;
    }

    static void myConsumer(List<Integer> list, Consumer<Integer> consumer) {
        //  这里不可以 new list 没有用  并且 consumer的返回值一般是 void
        for (Integer number : list) {
            // 现在是打印消费 消费规则以后需要变
            consumer.accept(number);
        }
    }

    static List<Integer> mySupplier(int count, Supplier<Integer> supplier) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 生成随机数
            result.add(supplier.get());
        }
        return result;
    }
    static int myOperator(int a , int b  , IntBinaryOperator binaryOperator) {
        return binaryOperator.applyAsInt(a, b);
    }

    public static void main(String[] args) {
//        System.out.println(myFilter(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (integer) -> integer % 2 == 0));
//        System.out.println(myMap(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), (integer) -> String.valueOf(integer)));
//        myConsumer(List.of(1, 2, 3, 4, 5, 6, 7), (integer) -> System.out.println(integer));
//        System.out.println(mySupplier(3, () -> ThreadLocalRandom.current().nextInt()));

//        LambdaSystem.OneElementInputTandReturnR<Double, Double> oneElementInputTandReturnR = Math::abs;
//        System.out.println(oneElementInputTandReturnR.operate(-1.0));

        IntBinaryOperator binaryOperator = (int a, int b) -> Math.max(a, b);

        System.out.println(myOperator(1, 2, binaryOperator));



    }
}
