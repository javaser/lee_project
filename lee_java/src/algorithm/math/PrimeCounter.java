package algorithm.math;

import java.util.Scanner;

public class PrimeCounter {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m, n, index, count;
        while (cin.hasNext()) {
            m = cin.nextInt();
            n = cin.nextInt();
            index = 0;
            count = 0;
            if (m > n) {
                m ^= n;
                n ^= m;
                m ^= n;
            }
            for (int i = 2; ; i++) {
                if (isPrime(i)) {
                    count++;
                    if (count >= m) {
                        index++;
                        System.out.print(i + " ");
                        if (index % 10 == 0) {
                            System.out.println();
                            System.out.println();
                        }
                    }
                }

                if (n == count) break;
            }
//            if (index % 10 != 0) System.out.println();
        }
    }

    private static boolean isPrime(int i) {
        if (i < 2) return false;
        if (i == 2 || i == 3) return true;
        if (i % 2 == 0) return false;
        boolean is = true;
        for (int j = 3; j <= Math.sqrt(i); j += 2) {
            if (i % j == 0) {
                is = false;
                break;
            }
        }
        return is;
    }
}
