package strings.singlepattern;

public class Tries {

    private final Tries[] children;

    private boolean isTail;

    public Tries() {
        children = new Tries[26];
        isTail = true;
    }

    public void insert(String text) {
        Tries root = this;
        char[] ch = text.toCharArray();
        for (char c : ch) {
            int index = c - 'a';
            root.children[index] = new Tries();
            root = root.children[index];
        }
        root.isTail = true;
    }

    public boolean search(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return true;
        }
        char[] ch = pattern.toCharArray();
        Tries root = this;
        for (char c : ch) {
            int index = c - 'a';
            if (root.children[index] == null) {
                return false;
            }
            root = root.children[index];
        }

        return root.isTail;
    }
}
