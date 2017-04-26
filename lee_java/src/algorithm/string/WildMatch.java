package algorithm.string;

import java.util.Scanner;

/**
 * @author Lee
 * @since 2017/4/16
 */
public class WildMatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a;
        int lena;
        String b;
        int lenb;
        while (sc.hasNext()) {
            System.out.println(1);
            a = sc.nextLine();
            System.out.println(2);
            lena = sc.nextInt();
            System.out.println(3);
            b = sc.nextLine();
            System.out.println(4);
            lenb = sc.nextInt();
            System.out.println(chkWildMatch(a, lena, b, lenb));
        }
        sc.close();
    }

    public static boolean chkWildMatch(String a, int lena, String b, int lenb) {
        if (lena > 300 || lenb > 300 || lenb > lena) {
            return false;
        }

        return a.matches(b);
    }
}
