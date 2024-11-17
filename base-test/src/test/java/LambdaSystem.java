import com.google.common.base.Supplier;

import java.util.ArrayList;
import java.util.List;

public class LambdaSystem {

    @FunctionalInterface
    interface LambdaType1 {
        boolean operate(int a, int b);
    }

    @FunctionalInterface
    interface LambdaType2<T> {
        T operate();
    }

    @FunctionalInterface
    interface LambdaType3<T , R> {
        R operate(T input);
    }

    public static void main(String[] args) {
        LambdaType1 lambdaType1 = (int a, int b) -> a == b;
        LambdaType2<List<Object>> arrayListLambdaType2 = () -> new ArrayList<>();
        LambdaType2<String[]> type2 = () -> new String[]{};
//        Supplier<String[]> type21 = () -> new String[]{};

        LambdaType3<Integer, String> integerStringLambdaType3 = (Integer a) -> a.toString();
        // 等价于：
        LambdaType3<Integer, String> integerStringLambdaType4 = (a) -> a.toString();


        ArrayList<Object> objects = new ArrayList<>();
//        objects.stream().filter(lambdaType1::operate).collect()
    }
}
