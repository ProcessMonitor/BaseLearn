package Interview.tata;

import java.util.Scanner;

public class palindromicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = getPalindromicPrime(n);
        System.out.println(result);
    }

    public static int getPalindromicPrime(int n) {
        while (true) {
            if (isPrime(n) && isPalindromic(n)) {
                return n;
            }
            n++;
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(int n) {
        int temp = n;
        int reverse = 0;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return n == reverse;
    }
}
