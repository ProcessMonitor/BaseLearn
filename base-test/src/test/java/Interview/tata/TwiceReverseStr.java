package Interview.tata;

import java.util.Scanner;

public class TwiceReverseStr {
    public static void main(String[] args) {
//        String input = "hello world";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(twiceReverse(input));
    }

    public static String twiceReverse(String str) {
        // split eng words
        String[] words = str.split(" ");

        // rev words order
        StringBuilder reversedWords = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedWords.append(words[i]).append(" ");
        }

        // rev whole str order
        String finalResult = reversedWords.toString().trim();
        return new StringBuilder(finalResult).reverse().toString();
    }
}