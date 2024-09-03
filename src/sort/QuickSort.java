package sort;

import java.util.Arrays;

import static utils.CommonUtils.swap;

public class QuickSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    //1. 选取数组最左端元素作为基准数，初始化两个指针i 和j 分别指向数组的两端。
    //2. 设置一个循环，在每轮中使用i（j）分别寻找第一个比基准数大（小）的元素，然后交换这两个元素。
    //3. 循环执行步骤2. ，直到i 和j 相遇时停止，最后将基准数交换至两个子数组的分界线。
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j--;
            }
            while (i < j && nums[i] <= nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 1, 5, 7, 8, 3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
