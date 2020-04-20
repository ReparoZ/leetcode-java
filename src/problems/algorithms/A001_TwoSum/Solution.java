package problems.algorithms.A001_TwoSum;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author steven.zmj
 * @date 2020/04/20
 */
public class Solution {

    /**
     * Solution 1: Use hashmap to find the number and pos u need.
     *
     * Time complexity : O(n).
     * Space complexity : O(n).
     *
     * For reference only:
     * Runtime: 1 ms, 99.91%
     * Memory Usage: 39.8 MB, 5.65%
     */
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            final int currentNum = nums[i];
            final int needNum = target - currentNum;
            if (numMap.containsKey(needNum)) {
                return new int[] {numMap.get(needNum), i};
            }

            numMap.put(currentNum, i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
