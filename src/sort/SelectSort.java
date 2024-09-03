package sort;

import java.time.LocalDate;
import java.time.Period;

import static utils.CommonUtils.swap;

//选择排序
public class SelectSort {

    //先从下标[0,n-1]选取最小/大元素与位置0交换
    //再从下标[1，n-1]选取最小/大元素与位置1交换
    //循环往复
    public static void sort(int[] nums){
        if (nums == null || nums.length <= 1){
            return;
        }

        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if (nums[min]>nums[j]){
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,4,1,5,7,8,3};
//        sort(nums);
//        System.out.println(Arrays.toString(nums));

     //   System.out.println(pow(39,3,10));
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.minus(Period.ofDays(1));
        Period period = Period.between(date, date1);


        System.out.println(period.getDays());
    }

    private static int pow(int a, int b, int m){
        int result = 1;
        int value = 1;
        for(int i=0;i<b;i++){
            value *= a;
            if(value > m){
                value %= m;
            }
        }
        return value % m;
    }
}
