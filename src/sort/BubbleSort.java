package sort;

import java.util.Arrays;

import static utils.CommonUtils.swap;

public class BubbleSort {


    //从下标[0,n-1]相邻元素比较大小，遇到左>右，交换位置，这样最后一位为最大元素
    //从下标[0,n-2]相邻元素比较大小，遇到左>右，交换位置，这样最后一位为最大元素
    // 。。。直到交换所有
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public static void sortWithFlag(int[] nums){
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            boolean flag = false;
            for (int j = 1; j <= i; j++) {
                if (nums[j-1] > nums[j]) {
                    swap(nums, j, j - 1);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,1,5,7,8,3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
