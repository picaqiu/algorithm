package sort;

import java.util.Arrays;

public class RadixSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int exp = 1; exp <= max; exp *= 10) {
            countSortByDigit(nums, exp);
        }
    }

    private static void countSortByDigit(int[] nums, int exp) {
        int[] counter = new int[10];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = digit(nums[i], exp);
            counter[index]++;
        }

        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
        }

        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int d = digit(nums[i], exp);
            int index = counter[d] - 1;
          //  System.out.println("index is :" + index);
            result[index] = nums[i];
            counter[d]--;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }

    private static int digit(int num, int exp) {
        return (num / exp) % 10;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
          1111,
          2222,
          1112,
          1114,
          2223, 1113,9999,4444,5555,3333
        };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
