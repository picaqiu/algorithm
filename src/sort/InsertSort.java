package sort;

import java.util.Arrays;

public class InsertSort {

    //以下标为1的元素为base，插入，往前寻找base的位置，遇到比base大的元素，向右挪动1位，直到找到base的位置
    //以下标为2的为元素为base，插入。。。
    //以下标为3的元素为base，插入
    //循环往复直至完毕

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
//        int n = nums.length;
//        for (int i = 1; i < n; i++) {
//            int base = nums[i];
//            int j = i - 1;
//            while (j >= 0 && nums[j] > base) {
//                nums[j + 1] = nums[j];
//                j--;
//            }
//            nums[j + 1] = base;
//        }
        int n = nums.length;
        for(int i=1;i<n;i++){
            int base = nums[i];
            int j =i-1;
            while(j>=0 && nums[j]>base){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = base;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 1, 5, 7, 8, 3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
