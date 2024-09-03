package sort;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap(List<Integer> data) {
        this.heap = new ArrayList<>(data);
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void heapUp(int i) {
        int parent = parent(i);
        if (parent >= 0 && heap.get(parent) < heap.get(i)) {
            swap(i, parent);
            i = parent;
            heapUp(i);
        }
    }

    private void heapDown(int i) {
        int left = left(i);
        int right = right(i);
        int max = i;
        if (left < size() && heap.get(left) > heap.get(max)){
            max = left;
        }
        if (right < size() && heap.get(right) > heap.get(max)){
            max = right;
        }
        if (max == i){
            return;
        }
        swap(max, i);

        heapDown(max);
    }

    public int size() {
        return this.heap.size();
    }

    public void print(){


    }

    private boolean isEmpty() {
        return size() == 0;
    }

    public int peek() {
        return this.heap.get(0);
    }

    public void push(int num) {
        heap.add(num);
        heapUp(heap.size() - 1);
    }

    /* 元素出堆 */
    public int pop() {
return 0;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
