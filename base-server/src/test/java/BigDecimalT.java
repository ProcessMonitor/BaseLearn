import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

public class BigDecimalT {


    @Test
    void testBigDecimal() {

        try {
            String resultVal = "8.9";
            String resultChar = "10.1";
            BigDecimal itemValue = new BigDecimal(resultVal);
            BigDecimal itemValueChar = new BigDecimal(resultChar);
            System.out.println(itemValue);
            System.out.println(itemValueChar);

        } catch (Exception e) {
            System.out.println("无法转换");
        }

        System.out.println(" over !");

    }

    @Test
    void testData() {

//        try {
//            String resultVal = ">=";
//            String resultChar = ">";
////            BigDecimal itemValue = new BigDecimal(resultVal);
////            BigDecimal itemValueChar = new BigDecimal(resultChar);
//            System.out.println(resultVal.contains(">"));
//            System.out.println(resultChar.contains(">"));
//
//        } catch (Exception e) {
//            System.out.println("无法转换");
//        }

        for (int i = 0; i < 1; i++) {
            // 拿文件名
            System.out.println(i);
            System.out.println(++i);
            System.out.println(i);
        }
        System.out.println(" over !");

    }
}
