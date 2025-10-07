import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AopTest {

    @Test
    void aopTester() {

    }

    public static String change2Yuan(int money) {
        BigDecimal base = BigDecimal.valueOf(money);
        BigDecimal yuanBase = base.divide(new BigDecimal(100));
        return yuanBase.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public static int change2Fen(int money) {
        BigDecimal base =  new BigDecimal(money);
        BigDecimal fenBase = base.multiply(new BigDecimal(100));
        return fenBase.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    public static void main(String[] args) {
        System.out.println(change2Yuan(123));
        System.out.println(change2Fen(123));

    }
}
