import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public int addab(int a, int b) {
        return a + b;
    }
}

//public class Main {
//    public static void main(String[] args) {
//        // 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和 输入数据多组
//        Scanner cin = new Scanner(System.in);
//        while (cin.hasNextInt()) {
//            int n = cin.nextInt();
//            int m = cin.nextInt();
//            double sum = 0.0;
//            double current = n;
//            for (int i = 0; i < m; i++) {
//                sum += current;
//                current = Math.sqrt(current);
//            }
//            // 保留两位小数
//            System.out.printf("%.2f\n", sum);
//        }
////        int a, b;
////        while (cin.hasNextInt()) {
////            a = cin.nextInt();
////            b = cin.nextInt();
////            Solution s = new Solution();
////            int c = s.addab(a, b);
////            System.out.println(c);
////
////        }
//    }
//}

public class Main {
    public static void main(String[] args) {
        // 原始输入数据行文本 （包含数字）
        // eg. dnsia434nidnsca321321iadsa1 删除字母提取每一段数字 并用空格间隔
//        Scanner cin = new Scanner(System.in);
//        while (cin.hasNext()) {
//            String line = cin.nextLine();
//            String[] numbers = line.replaceAll("[a-zA-Z]", " ").split("\\s+");
//            // 特殊字符删除
//            for (String number : numbers) {
//                try {
//                    System.out.println(number);
//                } catch (NumberFormatException e) {
//                    // 忽略非数字字符串
//                    continue;
//                }
//            }
//        }
//        while (cin.hasNextInt()) {
//            int m = cin.nextInt();
//            int n = cin.nextInt();
//            int count = 0;
//            for (int i = m; i <= n; i++) {
//                int a = i / 100;
//                int b = i / 10 % 10;
//                int c = i % 10;
//                if (a * a * a + b * b * b + c * c * c == i) {
//                    System.out.println(i);
//                    count++;
//                }
//            }
//            if (count == 0) {
//                System.out.println("no");
//            }
//        }


//        1. 有n个格子展柜 值为闪亮度  n个宝物 值为美观度 求a[i] * b[j]
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        // 格子的数量
        int[] a = new int[n];
        // 宝物的数量
        int[] b = new int[n];
        // 善良
        for (int i = 0; i < n; i++) a[i] = cin.nextInt();
        // 美观
        for (int i = 0; i < n; i++) b[i] = cin.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
//        2
// 1 2
// 2 3
//        输出 8

        for (int i = 0; i < n; i++) {
//            sum += (long) a[n - 1 - i] * b[i];
            sum += a[i] * b[i];
        }
        System.out.println(sum);
    }
}

