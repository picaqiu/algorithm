package tree;

import utils.PrintUtil;

import java.util.*;

public class MaxHeap {
    private final List<Integer> data;


    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    /* 构造方法，根据输入列表建堆 */
    public MaxHeap(List<Integer> nums) {
        // 将列表元素原封不动添加进堆
        data = new ArrayList<>(nums);
        // 堆化除叶节点以外的其他所有节点
        for (int i = parent(size() - 1); i >= 0; i--) {
            heapify(i);
        }
    }

    public void push(int value) {
        this.data.add(value);
        siftUp(this.data.size() - 1);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Out of index,the heap is empty");
        }
        swap(0, size() - 1);
        int top = this.data.remove(size() - 1);
        heapify(0);
        return 0;
    }

    public int peek() {
        return data.get(0);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    private void swap(int i, int j) {
        int temp = this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, temp);
    }

    private void siftUp(int i) {
        int cur = i;
        while (parent(cur) >= 0 && data.get(cur) > data.get(parent(cur))) {
            swap(cur, parent(cur));
            cur = parent(cur);
        }
    }

    private void heapify(int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = left(i), r = right(i), ma = i;
            if (l < size() && data.get(l) > data.get(ma))
                ma = l;
            if (r < size() && data.get(r) > data.get(ma))
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            swap(i, ma);
            // 循环向下堆化
            i = ma;
        }
    }

    /* 打印堆（二叉树） */
    public void print() {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        queue.addAll(data);
        PrintUtil.printHeap(queue);
    }

    public static void main(String[] args) {
        /* 初始化大顶堆 */
        MaxHeap maxHeap = new MaxHeap(Arrays.asList(9, 8, 6, 6, 7, 5, 2, 1, 4, 3, 6, 2));
        System.out.println("\n输入列表并建堆后");
        maxHeap.print();

        /* 获取堆顶元素 */
        int peek = maxHeap.peek();
        System.out.format("\n堆顶元素为 %d\n", peek);

        /* 元素入堆 */
        int val = 7;
        maxHeap.push(val);
        System.out.format("\n元素 %d 入堆后\n", val);
        maxHeap.print();

        /* 堆顶元素出堆 */
        peek = maxHeap.pop();
        System.out.format("\n堆顶元素 %d 出堆后\n", peek);
        maxHeap.print();

        /* 获取堆大小 */
        int size = maxHeap.size();
        System.out.format("\n堆元素数量为 %d\n", size);

        /* 判断堆是否为空 */
        boolean isEmpty = maxHeap.isEmpty();
        System.out.format("\n堆是否为空 %b\n", isEmpty);
    }
}
