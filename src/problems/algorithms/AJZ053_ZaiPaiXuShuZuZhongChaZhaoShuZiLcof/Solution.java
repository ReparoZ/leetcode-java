package problems.algorithms.AJZ053_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/07/16
 */
public class Solution {

    /**
     * 解 1：暴力解法
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 27.22%
     * Memory Usage: 41.1 MB, 87.04%
     */
    public int search1(int[] nums, int target) {
        int result = 0;
        for (int num : nums) {
            if (num == target) {
                result++;
            }
        }

        return result;
    }

    /**
     * 解 2：暴力解法
     *
     * 时间复杂度 : O(logn).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 41.5 MB, 13.70%
     */
    public int search2(int[] nums, int target) {
        final int leftIdx = binarySearch(nums, target, true);
        final int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }

        return 0;
    }

    private int binarySearch(final int[] nums, int target, boolean lower) {
        int start = 0, end = nums.length - 1, result = nums.length;
        while (start <= end) {
            final int middle = (start + end) / 2;
            if (nums[middle] > target || (lower && nums[middle] >= target)) {
                end = middle - 1;
                result = middle;
            } else {
                start = middle + 1;
            }
        }

        return result;
    }
}
