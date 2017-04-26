package lee.jdk.test;

import java.util.Scanner;

/**
 * @author Lee
 * @since 2016/12/21
 */
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int countodd = 0;
            int counteven = 0;
            int n = s.nextInt();
            s.nextLine();
            System.out.println(n);

            for (int i = 0; i < n; i++) {
                int m = s.nextInt();
                System.out.println(m);
                if (m % 2 != 0)
                    countodd++;
                else
                    counteven++;
            }
            if (countodd < counteven)
                System.out.println("NO\n");
            else
                System.out.println("YES\n");
        }
    }
}
