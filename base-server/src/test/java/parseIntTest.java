public class parseIntTest {

public static int stringToInt(String str) {
        if (str == null || str.isEmpty()) {
            throw new NumberFormatException("String is null or empty.");
        }

        int result = 0;
        boolean isNegative = false;
        int i = 0;

        // 正负数处理
        if (str.charAt(0) == '-') {
            isNegative = true;
            i = 1;
        } else if (str.charAt(0) != '-') {
            i = 0;
        }

        // 传唤数字
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                throw new NumberFormatException(" found invalid number : " + c);
            }

            // 累加
            result = result * 10 + (c -'0');
            System.out.println( c);
            System.out.println( c - '0');
        }

        // 恢复符号位
        return isNegative ? -result : result;
    }

 public static void main(String[] args) {
        String str = "123";
        int result = stringToInt(str);
        System.out.println("result: " + result);
    }
}
