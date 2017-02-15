package algorithm.time;

public class WhichMonthsHave31Day {
    public static void main(String[] args) {
        int month = 1;
        while (month <= 12) {
            if (fist(month)) {
                System.out.println(month);
            }
            month++;
        }
    }

    private static boolean fist(int month) {
        return month == 7 ? true : month % 7 % 2 != 0;
    }
}
