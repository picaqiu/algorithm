package strings.singlepattern;

import java.util.Arrays;

public class BoyerMoore {
    private final static int tableSize = 256;
    private final static int[] badCharTable = new int[tableSize];
    private static int[] goodSuffix;
    private static boolean[] prefix;

    private static void buildBadCharTable(String pattern) {
        int patternLen = pattern.length();
        Arrays.fill(badCharTable, -1);

        for (int i = 0; i < patternLen; i++) {
            int index = pattern.charAt(i);
            badCharTable[index] = i;
        }
    }

    private static void buildGoodSuffixTable(String pattern) {
        int pLen = pattern.length();
        goodSuffix = new int[pLen];
        prefix = new boolean[pLen];

        Arrays.fill(goodSuffix, -1);
        Arrays.fill(prefix, false);

        for (int i = 0; i < pLen - 1; i++) {
            int index = i;
            int suffixLen = 0;

            while (index >= 0 && pattern.charAt(index) == pattern.charAt(pLen - 1 - suffixLen)) {
                index--;
                suffixLen++;
                goodSuffix[suffixLen] = index + 1;
            }
            if (index == -1) {
                prefix[suffixLen] = true;
            }
        }
    }


    public static int search(String text, String pattern) {
        if (text == null || pattern == null || text.isEmpty()) {
            return -1;
        }
        if (text.length() < pattern.length()) {
            return -1;
        }
        int index = 0;
        buildBadCharTable(pattern);
        buildGoodSuffixTable(pattern);

        while (text.length() - index >= pattern.length()) {
            int i;
            for (i = pattern.length() - 1; i >= 0; i--) {
                if (pattern.charAt(i) != text.charAt(i + index)) {
                    break;
                }
            }
            //完全匹配
            if (i == -1) {
                return index;
            }
            //使用好坏字符表
            int stepByBadChar = i - badCharTable[i + index];
            int stepByGoodSuffix = moveByGoodSuffix(pattern, i);

            index += Math.max(stepByBadChar, stepByGoodSuffix);
        }

        return -1;
    }

    private static int moveByGoodSuffix(String pattern, int index) {
        int len = pattern.length() - 1 - index;
        if (len == 0) {
            return pattern.length();
        }
        if (goodSuffix[len] != -1) {
            return index - goodSuffix[len] + 1;
        }
        for (int i = len - 1; i > 0; i--) {
            if (prefix[i]) {
                return pattern.length() - i;
            }
        }

        return pattern.length();
    }


    public static void main(String[] args) {
        System.out.println(search("ababeabcdeabc", "abcdeabc"));
    }
}
