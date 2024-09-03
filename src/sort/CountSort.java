package sort;

import java.util.Arrays;

public class CountSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int max = 0;
        int n = nums.length;
        int[] result = new int[n];
        /* 1.find the max num */
        for (int num : nums) {
            max = Math.max(max, num);
        }
        //create an array to count the number of the array
        int[] counter = new int[max + 1];
        //统计num[i]的个数
        for (int num : nums) {
            counter[num]++;
        }
        //求count[i]的前缀和
        //count[i]表示小于等于num[i]的个数
        for (int i = 1; i <= max; i++) {
            counter[i] += counter[i - 1];
        }
        //倒序，因为count[num]表示比<=num的个数
        //那么count[num]-1即为在result数组的位置index
        //放置完之后，个数-1
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            result[counter[num] - 1] = num;
            counter[num]--;
        }
        //复制result数组给原数组
        System.arraycopy(result, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,5,4,2,2,3,3,1};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println("--------after sort-------------");
        System.out.println(Arrays.toString(nums));
    }
}
