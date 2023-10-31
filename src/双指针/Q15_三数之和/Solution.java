package 双指针.Q15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解题思路：
 *   除了暴力求解，哪还几把有别的思路啊！！！
 *   这个题真几把难啊，暴力求解倒是能写，但是要用双指针着实有点难以下手，麻辣隔壁，真几把菜！！！
 */

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        // 如果数组长度小于3直接返回空
        if (nums == null || nums.length < 3) return res;

        // 对数组元素排序
        Arrays.sort(nums);

        // 循环数组元素，i相当于一个基准，只从前往后走一遍循环
        for (int i = 0; i < nums.length; i++) {

            // 如果当前轮次第一个元素就已经大于0，则直接跳出循环，因为数组已排序，后边不可能再有小于0的元素
            if (nums[i] > 0) break;

            // 从第二轮开始，如果当前轮次的首个元素和上一个元素相等，说明此组数据已经计算过，不需要再计算一次，直接开始下一轮计算
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 初始化每个轮次开始计算时的左右位置指针
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {// 每个轮次i是固定不动的，如果sum小于0，只能将左指针后移，才能使sum的值增大，这样才有sum=0的可能
                    left++;
                } else if (sum > 0) {// 每个轮次i是固定不动的，如果sum大于0，只能将右指针后移，才能使sum的值减小，这样才有sum=0的可能
                    right--;
                } else { // sum == 0

                    // 将本次组合结果得0的三个元素添加到结果集中
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {// 如果left指针的下一个元素和当前left元素值相同，不用再重复计算，直接跳过
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {// 如果right指针的前一个元素和当前right元素值相同，不用再重复计算，直接跳过
                        right--;
                    }

                    // 如果left指针下一个元素和当前left元素值不同，left指针后移，right指针的前一个元素和当前right元素值不同，right指针前移
                    left++;
                    right--;
                }
            }
        }

        return res;
    }

}
