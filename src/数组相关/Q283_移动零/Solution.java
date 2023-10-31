package 数组相关.Q283_移动零;

import java.util.Arrays;

public class Solution {

    public void moveZeroes(int[] nums) {

        // 题目要求不复制数组
        // int[] array = new int[nums.length];
        // int i = 0;
        // for (int num : nums) {
        //     if (num != 0) array[i++] = num;
        // }


        int noZeroIndex = 0;
        int currentNumber;
        for (int i = 0; i < nums.length; i++) {
            currentNumber = nums[i];
            if (currentNumber != 0) {
                if (i > noZeroIndex) nums[i] = 0;
                nums[noZeroIndex++]=currentNumber;
            }
        }

        System.out.println(Arrays.toString(nums));




    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
    }


}
