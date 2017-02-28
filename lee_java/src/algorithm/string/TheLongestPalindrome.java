package algorithm.string;

import java.util.Scanner;

/**
 * @author Lee
 * @since 2017/2/28
 */
public class TheLongestPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int longest;
        while (sc.hasNext()) {
            str = sc.nextLine();
            longest = getTheLongestPalindromeLength(str);
            System.out.println(str + " 最大回文数有 " + longest + " 位。");
        }

        sc.close();
    }

    /**
     * 删除个别字符，使之得到最大的回文串
     * @param str
     * @return 最大的回文个数
     */
    private static int getTheLongestPalindromeLength(String str) {
        int longest = -1;
        if (str == null || str.length() == 0) {
            return longest;
        } else if (str.length() == 1) {
            longest = 1;
        } else if (str.length() == 2) {
            longest = str.charAt(0) == str.charAt(1) ? 2 : 1;
        } else {
            StringBuilder sb = new StringBuilder(str);
            int insertPositioning = 1;  // 初始插入位置
            int left; // 回文串对称线的左边下标
            int right; // 回文串对称线的右边下标
            int max = 0; // 最大子串的回文长度
            int temp = 0; // 子串的回文长度
            while (insertPositioning < str.length()) {
                if (max < temp) {
                    max = temp;
                }
                left = insertPositioning - 1;
                right = insertPositioning + 1;
                sb.insert(insertPositioning, '|'); // 对称线
                if (sb.charAt(left) != sb.charAt(right)) {
                    temp = 1; // 对称中心
                    right++;
                } else
                    temp = 0;
                while (left >= 0 && right < sb.length()) {
                    if (sb.charAt(left) == sb.charAt(right)) {
                        temp += 2;
                        left--;
                    } else if (right == sb.length() - 1) {
                        // 对称线右边全都和左边 left 上的字符不想等
                        left--;
                        right = insertPositioning + 1;
                    }
                    right++;
                }

                sb.delete(insertPositioning, insertPositioning + 1);
                insertPositioning++;
            }
            longest = max;
        }

        return longest;
    }
}
