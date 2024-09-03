package list;

import java.util.Random;

public class SkipList {

    private final int maxLevel = 16;

    private int levelCount = 1;

    private final Node head = new Node(maxLevel);

    private final Random r = new Random();

    public Node search(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forward[i] != null && p.forward[i].data < value) {
                p = p.forward[i];
            }
        }
        if (p.forward[0] != null && p.forward[0].data == value) {
            return p.forward[0];
        }
        return null;
    }

    public void insert(int value) {
        int level = randomLevel();
        if (level > levelCount) {
            level = ++levelCount;
        }

        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.forward[i] != null && p.forward[i].data < value) {
                p = p.forward[i];
            }
            if (p.forward[i] == null) {
                p.forward[i] = newNode;
            } else {
                Node next = p.forward[i];
                p.forward[i] = newNode;
                newNode.forward[i] = next;
            }
        }
    }

    public void delete(int value) {
        Node p = head;
        Node[] q = new Node[levelCount];
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forward[i] != null && p.forward[i].data < value) {
                p = p.forward[i];
            }
            q[i] = p;
        }
        if (p.forward[0] != null && p.forward[0].data == value) {
            for (int i = levelCount - 1; i >= 0; i--) {
                if (q[i].forward[i] != null && q[i].data == value) {
                    q[i].forward[i] = q[i].forward[i].forward[i];
                }
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < maxLevel; i++) {
            if (r.nextInt() % 2 == 0) {
                level++;
            }
        }
        return level;
    }

    public class Node {
        private int data = -1;

        private final Node[] forward;

        public Node(int level) {
            forward = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append(" }");
            return builder.toString();
        }
    }
}
