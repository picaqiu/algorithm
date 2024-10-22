package strings.singlepattern;

public class KMP {

    private int[] getNext(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return new int[1];
        }

        int len = pattern.length();
        int[] next = new int[len];
        int index = 0;
        for (int j = 1; j < len; j++) {
            while (index > 0 && pattern.charAt(index) != pattern.charAt(j)) {
                index = next[index - 1];
            }
            if (pattern.charAt(index) == pattern.charAt(j)) {
                index++;
            }
            next[j] = index;
        }

        return next;
    }

    public int match(String text, String pattern) {
        if (text == null || text.isEmpty() || pattern == null
                || pattern.length() > text.length()) {
            return -1;
        }
        int j = 0;
        int[] next = getNext(pattern);

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }

        return -1;
    }
}
