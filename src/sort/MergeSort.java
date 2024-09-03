package sort;

import java.util.Arrays;


public class MergeSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
    }


    private static void mergeSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i=left,j=mid+1;
        int index = 0;
        while(i<=mid && j<=right){
            if (nums[i] <= nums[j]){
                temp[index++] = nums[i++];
            }else{
                temp[index++] = nums[j++];
            }
        }
        while(i<=mid){
            temp[index++] = nums[i++];
        }
        while(j<=right){
            temp[index++] = nums[j++];
        }

        for(int k=0;k<temp.length;k++){
            nums[left+k] = temp[k];
        }

    }

//    public static void mergeSort(int[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int mid = left + (right - left) / 2;
//        mergeSort(nums, left, mid);
//        mergeSort(nums, mid + 1, right);
//        merge(nums, left, mid, right);
//    }

//    private static void merge(int[] nums, int left, int mid, int right) {
//        int i = left, j = mid + 1;
//        int n = right - left + 1;
//        int[] temp = new int[right - left + 1];
//        int index = 0;
//        while (i <= mid && j <= right) {
//            if (nums[i] <= nums[j]) {
//                temp[index++] = nums[i++];
//            } else {
//                temp[index++] = nums[j++];
//            }
//        }
//        while (i <= mid) {
//            temp[index++] = nums[i++];
//        }
//        while (j <= right) {
//            temp[index++] = nums[j++];
//        }
//        for (int k = 0; k < n; k++) {
//            nums[left + k] = temp[k];
//        }
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 1, 5, 7, 8, 3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
