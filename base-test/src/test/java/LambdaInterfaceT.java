import java.util.ArrayList;
import java.util.List;

public class LambdaInterfaceT {

    @FunctionalInterface
    interface TwoElementReturnBoolean {
        boolean operate(int a, int b);
    }

    @FunctionalInterface
    interface NoElementReturnAbstractT<T> {
        T operate();
    }

    @FunctionalInterface
    interface OneElementInputTandReturnR<T , R> {
        R operate(T input);
    }

    public static void main(String[] args) {
        TwoElementReturnBoolean twoElementReturnBoolean = (int a, int b) -> a == b;
        NoElementReturnAbstractT<List<Object>> arrayListNoElementReturnAbstractT = () -> new ArrayList<>();
        NoElementReturnAbstractT<String[]> type2 = () -> new String[]{};
//        Supplier<String[]> type21 = () -> new String[]{};

        OneElementInputTandReturnR<Integer, String> integerStringOneElementInputTandReturnR = (Integer a) -> a.toString();
        // 等价于：
        OneElementInputTandReturnR<Integer, String> integerStringLambdaType4 = (a) -> a.toString();


        ArrayList<Object> objects = new ArrayList<>();
//        objects.stream().filter(lambdaType1::operate).collect()
    }
}
