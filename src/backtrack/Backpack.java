package backtrack;

/*
有N件物品和一个容量为V 的背包。放入第i件物品耗费的空间是Ci，得到
的价值是Wi。求解将哪些物品装入背包可使价值总和最大。
*/
public class Backpack {
    private int max = Integer.MIN_VALUE;

    public int backpack(int[] C, int V) {
        int N = C.length;

        backtrack(C, N, 0, V, 0);

        return max;
    }

    private void backtrack(int[] C, int N, int i, int V, int cc) {
        if (cc > V) {
            return;
        }
        if (cc == V || i == N) {
            if (cc > max) {
                max = cc;
            }
            return;
        }
        if (cc + C[i] <= V) {
            backtrack(C, N, i + 1, V, cc + C[i]);
        }
        backtrack(C, N, i + 1, V, cc);

    }

    public static void main(String[] args) {
        int[] C = { 2,3,7,10 };
        Backpack b = new Backpack();
        System.out.println(b.backpack(C, 18));
    }
}
