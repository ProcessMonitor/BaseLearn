import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class T1 {

    private static int m;
//    public static void T1(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        scanner.close();
//
//        String[] words = line.split("\\s+");
//        int count = 0;
//
//        for (String word : words){
//            if(!word.isEmpty() && Character.isUpperCase(word.charAt(0))){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }


    public static void T2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 物品个数
        int n = scanner.nextInt();
        // 标签种类
        m = scanner.nextInt();
        int[] suitesLabel = new int[n];
        int[] beautyWithLabel = new int[n];
        int[] beautyWithOutLabel = new int[n];

        for (int i = 0; i < n; i++) {
            suitesLabel[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            beautyWithLabel[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            beautyWithOutLabel[i] = scanner.nextInt();
        }
        scanner.close();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i, beautyWithLabel[i], beautyWithOutLabel[i], suitesLabel[i]);
        }
        Arrays.sort(items);
        Collections.reverse(Arrays.asList(items));

        int[] labels = new int[m];
        long maxBeauty = 0;
        for (Item item : items) {
            for (int label = 0; label < m; label++) {
                if (item.suiteLabels[label] == 1 && labels[label] == 0) {
                    labels[label] = 1;
                    maxBeauty += item.beautyWithLabel;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (items[i].suiteLabels[Arrays.stream(labels).filter(x -> x == 1).toArray().length] == 0) {
                maxBeauty += items[i].beautyWithOutLabel;
            }
        }
        System.out.println(maxBeauty);

    }

    static class Item implements Comparable<Item> {
        int index;
        int beautyWithLabel;
        int beautyWithOutLabel;
        int[] suiteLabels;

        public Item(int index, int beautyWithLabel, int beautyWithOutLabel, int suiteLabel) {
            this.index = index;
            this.suiteLabels = new int[m];
            this.suiteLabels[suiteLabel] = 1;
            this.beautyWithLabel = beautyWithLabel;
            this.beautyWithOutLabel = beautyWithOutLabel;
        }

        @Override
        public int compareTo(@NotNull Item other) {
            return other.beautyWithLabel + other.beautyWithOutLabel -
                    (this.beautyWithLabel + this.beautyWithOutLabel);
        }
    }


    public static void T3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        for (int round = 0; round <= q; round++) {
            int oddCount = 0;
            for (int i = 0; i < n; i++) {
                if (cards[i] % 2 == 1) {
                    oddCount++;
                }
            }

            int peek = 0;
            if (oddCount >= 2) {
                peek = 0;
            } else if (oddCount == 1) {
                peek = 1;
            } else {
                peek = 2;
            }
            System.out.println(peek);

            if (round < q) {
                char operation = scanner.next().charAt(0);
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int x = scanner.nextInt();
                if (operation == '+') {
                    for (int i = l - 1; i < r; i++) {
                        cards[i] += x;
                    }
                } else {
                    for (int i = l - 1; i < r; i++) {
                        cards[i] -= x;
                        // 确保卡牌数量不会变成负数
                        if (cards[i] < 0) {
                            cards[i] = 0;
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of card types
        int q = scanner.nextInt(); // Number of rounds

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        System.out.println(calculateMinPeeks(cards));

        for (int round = 0; round < q; round++) {
            String operation = scanner.next();
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            int x = scanner.nextInt();

            updateCards(cards, operation, l, r, x);
            System.out.println(calculateMinPeeks(cards));
        }

        scanner.close();
    }

    private static int calculateMinPeeks(int[] cards) {
        int totalCards = Arrays.stream(cards).sum();
        if (totalCards < 2) return -1;

        int maxSingleType = Arrays.stream(cards).max().getAsInt();
        if (maxSingleType > totalCards / 2) return totalCards - maxSingleType;

        return (totalCards + 1) / 2 - 1;
    }

    private static void updateCards(int[] cards, String operation, int l, int r, int x) {
        for (int i = l; i <= r; i++) {
            if (operation.equals("+")) {
                cards[i] += x;
            } else if (operation.equals("-")) {
                cards[i] = Math.max(0, cards[i] - x);
            }
        }
    }
}
