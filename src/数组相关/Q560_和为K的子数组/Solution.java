package 数组相关.Q560_和为K的子数组;

public class Solution {

    public int subarraySum(int[] nums, int k) {

        int count = 0;

        if (nums.length == 0) return count;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1, -1, 0}, 0));
    }


}
