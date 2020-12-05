package problems.algorithms.A0001_TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/01
 */
public class Solution {

    /**
     * 解 1: 用Hashmap缓存你需要寻找的数和位置，通过第二个数来找第一个数，来避免第一轮的map初始化和重复数字
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 38.6 MB, 77.65%
     */
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> numsMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            final int another = target - nums[i];
            final Integer anotherNumIndex = numsMap.get(another);
            if (anotherNumIndex != null) {
                return new int[] {anotherNumIndex, i};
            } else {
                numsMap.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("no solution.");
    }
}