package algorithm.string;

/**
 * 朴素算法的复杂度为 O(mn)
 * KMP 算法的复杂度为 O(m + n)
 */
public class KMPSearch {

    public static void main(String[] args) {
//        String text = "abcbcglx";
//        String pattern = "bcgl";
        String text = "abxabcabcaby";
        String pattern = "abcaby";

        int index = indexOfStr(text, pattern);
        System.out.println("第一次匹配的地方是：" + index);

        /*int[] arr = computeTemporaryArray("aabaabaaa");
        System.out.println(Arrays.toString(arr));*/
    }

    public static boolean hasSubstring(String textStr, String patternStr) {
        char[] text = textStr.toCharArray();
        char[] pattern = patternStr.toCharArray();

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        if (j == pattern.length) {
            return true;
        }
        return false;
    }

    /**
     * 找到 pattern 在 text 第一次出现的位置
     *
     * @param textStr
     * @param patternStr
     * @return pattern 第一个字符的位置
     * -1 表示不匹配
     */
    private static int indexOfStr(String textStr, String patternStr) {
        int index = -1;
        char[] text = textStr.toCharArray();
        char[] pattern = patternStr.toCharArray();
        // KMP
        int lps[] = computeTemporaryArray(patternStr);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length) {
            index = i - pattern.length;
        }
        return index;
    }

    /**
     * 当字符不匹配时，可根据下标返回对应位置。
     * 目的：减少匹配次数
     *
     * @param patternStr
     * @return
     */
    private static int[] computeTemporaryArray(String patternStr) {
        char[] pattern = patternStr.toCharArray();
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
/* 个人解法
    private static int indexOfStr(String text, String pattern) {
        if (text == null || pattern == null
                || "".equals(text) || "".equals(pattern))
            return 0;
        int index = -1;
        // Before and after the same suffix
        int[] same = computeTemporaryArray(pattern);
        int length = text.length();
        boolean flag = true; // 记录是否让 i 自增
        for (int i = 0, j = 0; i < length; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    index = i - pattern.length() + 1;
                    break;
                }
                j++;
                flag = true;
            } else {
                while (j > 0) {
                    if (text.charAt(i) != pattern.charAt(j)) {
                        j = same[j - 1];
                    } else {
                        break;
                    }
                }
                if (flag) {
                    i--;
                    flag = false;
                }
            }
        }
        return index;
    }

    private static int[] computeTemporaryArray(String pattern) {
        if (pattern == null || "".equals(pattern)) {
            try {
                throw new Exception("字符串不能为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 该数组记录前缀与后缀相同的字符位置
        int[] arr = new int[pattern.length()];
        arr[0] = 0;
        if (arr.length > 1) {
            // i、j 表前缀和后缀最后一位字符相同的位置
            int i = 0, j = 1;
            for (int k = 1; k < arr.length; k++) {
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    arr[k] = i + 1; // 相同字符前缀后一位
                    // 移动下标
                    i++;
                    j++;
                } else {
                    while (true) {
                        if (i > 0) {
                            // 位移到前缀最后一位字符位置
                            i = arr[i - 1];
                            if (pattern.charAt(i) == pattern.charAt(j)) {
                                arr[k] = i + 1;
                                break;
                            }
                        } else {
                            i = 0;
                            j++;
                            break;
                        }
                    }
                }
            }
        }
        return arr;
    }
 */