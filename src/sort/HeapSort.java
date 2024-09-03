package sort;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] nums) {
        //建堆
        for (int i = parent(nums.length - 1); i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            siftDown(nums, i, 0);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void siftDown(int[] nums, int heapSize, int i) {
        int cur = i;
        while (true) {
            int max = cur;
            int left = left(cur);
            int right = right(cur);

            if (left < heapSize && nums[max] < nums[left]) {
                max = left;
            }
            if (right < heapSize && nums[max] < nums[right]) {
                max = right;
            }
            if (max == cur) {
                break;
            }
            swap(nums, max, cur);
            cur = max;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,5,2,3,1,4};
        System.out.println("排序前: " + Arrays.toString(nums));
        HeapSort heap = new HeapSort();
        heap.sort(nums);
        System.out.println("排序后: " + Arrays.toString(nums));
    }
}




