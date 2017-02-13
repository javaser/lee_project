package algorithm.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeletePublicCharacters {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String istr;
        String dStr;
        String result;
        while (cin.hasNext()) {
            istr = cin.nextLine();
            dStr = cin.nextLine();
            result = getResult(istr, dStr);
            System.out.println(result);
        }
    }

    private static String getResult(String istr, String dStr) {
        StringBuilder sb = new StringBuilder();
        Set<Character> chars = stringToCharSet(dStr);
        for (int i = 0; i < istr.length(); i++) {
            if (!chars.contains(istr.charAt(i)))
                sb.append(istr.charAt(i));
        }
        return sb.toString();
    }

    private static Set<Character> stringToCharSet(String dStr) {
        Set<Character> set = new HashSet<>();
        char[] dChar = dStr.toCharArray();
        for (char ch : dChar) {
            set.add(ch);
        }
        return set;
    }
}
