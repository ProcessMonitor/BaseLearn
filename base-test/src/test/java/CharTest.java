import java.sql.SQLOutput;

public class CharTest {

    public static void main(String[] args) {

        // 两个 Integer 初始化200 并 == 和 equals 比较
//         Double a = 100.0;
//         Double b = 100.0;
//         Double c = 200.0;
//         Double d = 200.0;
//         System.out.println(a == b);
//         System.out.println(c == d);
        System.out.println(test());
    }

    public static int test() {
        //try catch return 1 和 2 finall return3
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.println("3");;
        }
    }






}
