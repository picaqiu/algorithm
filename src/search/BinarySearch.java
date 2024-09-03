package search;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {


    //查找nums中是否存在目标target，并返回下标，找不到则返回-1
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //如果nums是有序数组则免去这步
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //查找第一个值等于给定值的元素
    public static int searchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;

    }

    //查找第一个值等于给定值的元素
    public static int searchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        return result;
    }

    //查找第一个大于等于给定值的元素
    public static int searchFirstLarge(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (result == -1 && left == nums.length) {
            return nums.length;
        }
        return result;
    }

    //查找最后一个小于等于给定值的元素
    public static int searchLastLess(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3, 3, 4, 5, 5};
        System.out.println(searchFirst(nums, 1));
        System.out.println(searchFirst(nums, 2));
        System.out.println(searchFirst(nums, 3));
        System.out.println(searchFirst(nums, 5));
        System.out.println("------------------------");
        System.out.println(searchLast(nums, 1));
        System.out.println(searchLast(nums, 2));
        System.out.println(searchLast(nums, 3));
        System.out.println(searchLast(nums, 5));
        System.out.println("------------------------");
        System.out.println(searchFirstLarge(nums, 1));
        System.out.println(searchFirstLarge(nums, 2));
        System.out.println(searchFirstLarge(nums, 3));
        System.out.println(searchFirstLarge(nums, 5));
        System.out.println("------------------------");
        System.out.println(searchLastLess(nums, 2));
        System.out.println(searchLastLess(nums, 3));
        System.out.println(searchLastLess(nums, 4));
        System.out.println(searchLastLess(nums, 5));
    }
}
