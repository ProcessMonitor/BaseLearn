package Interview.tata;

import java.util.Scanner;

public class OddEvenPrinterByTataInterview {
    private static int n;
    private static int current = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input n
        n = scanner.nextInt();
        Thread oddThread = new Thread(() -> printOddNumbers());
        Thread evenThread = new Thread(() -> printEvenNumbers());

        oddThread.start();
        evenThread.start();
    }

    private static void printOddNumbers() {
        while (current <= n) {
            synchronized (lock) {
                if (current % 2 != 0) {
                    System.out.println("oddThread: " + current);
                    current++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void printEvenNumbers() {
        while (current <= n) {
            synchronized (lock) {
                if (current % 2 == 0) {
                    System.out.println("evenThread: " + current);
                    current++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}