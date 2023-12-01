package 数组相关.Q189_轮转数组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 时间复杂度O(n)
 * 空间复杂度不是O(n)，也不是O(1)，是他妈的OK！！！
 *
 * 还是把问题复杂化了，以后不管刷题还是笔试，还是要优先考虑简单思路
 * 虽然题目中必须在原数组中操作，但仍然可以创建一个临时数组，最后再把原数组中的元素全部替换一下就行了，这虽然是时间换空间，但也算达到了目的
 * 在考试中，这种思路往往才是最简单，最省时间的
 *
 * 我最开始的思路：
 *   1. 把最后需要出界，重新放到数组的k个元素单独存起来
 *   2. 对nums数组从后往前遍历，替换掉所有需要后移的元素
 *   3. 把出界的k个元素替换掉nums数组的前k个元素（这里的k个元素在上一步中已经全部移动到了目标位置）
 */
public class Solution {

    public void rotate(int[] nums, int k) {

        if (k == 0 || nums.length == 0) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        int rn = k % nums.length;
        int[] temp = new int[rn];
        int pointer = rn - 1;
        for (int i = nums.length - 1; i >= 0; i--) {

            if (pointer >= 0) {
                temp[pointer] = nums[i];
                pointer--;
            }

            if (i - rn >= 0) nums[i] = nums[i - rn];

        }

        System.arraycopy(temp, 0, nums, 0, rn);


        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
//        new Solution().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//        new Solution().rotate(new int[]{1, 2, 3}, 2);
        new Solution().rotate(new int[]{1, 2}, 3);
    }


}
