package algorithm.dp;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence
 * where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
public class WordBreakIi {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> list = new ArrayList<>();
        if (s == null || "".equals(s) || dict == null || dict.isEmpty())
            return list;
        StringBuilder sb = new StringBuilder();
        Wrapper wrapper = new Wrapper(0);
        boolean[] b = new boolean[dict.size()];
        Arrays.fill(b, true);
        int index = 0;
        for (String start : dict) {
            if (s.startsWith(start)) {
                int location = 0;
                for (String str : dict) {
                    addString(s, wrapper, str, sb, b[location++]);
                }
                b[index] = false;
                list.add(sb.toString());
                sb.delete(0, sb.length());
                wrapper.index = 0;
            }
            index++;
        }
        return list;
    }

    private void addString(String s, Wrapper wrapper, String str,
                           StringBuilder sb, boolean flag) {
        if (s.startsWith(str) && !flag) return;
        if (s.substring(wrapper.index, wrapper.index + str.length()).equals(str)) {
            sb.append(str).append(" ");
            wrapper.index += str.length();
            if (wrapper.index == s.length()) {
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> set = new HashSet<>(Arrays.asList("cat", "cats", "and",
                "sand", "dog"));
        System.out.println(set);
        List<String> list = new WordBreakIi().wordBreak(s, set);
        System.out.println(list);
    }
}

class Wrapper {
    public int index;
    public Wrapper(int i) {
        this.index = i;
    }

    @Override
    public String toString() {
        return index + "";
    }
}
