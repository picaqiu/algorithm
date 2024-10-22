package strings.singlepattern;

//删除连续三个相同的字符串
public class DeleteTripleSameChar {

    public static String delete(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return delete(str, str.length());
    }

    public static String delete(String str, int len) {
        int index = 0;
        if (str.length() < 3) {
            return str;
        }
        StringBuffer result = new StringBuffer(str);
        while (index + 2 < result.length()) {
            if (result.charAt(index) == result.charAt(index + 1) && result.charAt(index) == result.charAt(index + 2)) {
                result.delete(index, index + 3);
            }
            index++;
        }
        if (result.length() == len || result.length() < 3) {
            return result.toString();
        }

        return delete(result.toString(), result.length());
    }

    public static void main(String[] args) {
        System.out.println(delete("babbbaab"));
        System.out.println(delete("babbbaabbc"));
        System.out.println(delete("babbbaabbb"));
    }
}
