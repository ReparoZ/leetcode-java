package problems.algorithms.A0162_FindPeakElement;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5 
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *     或者返回索引 5， 其峰值元素为 6。
 * 
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/12/4
 */
public class Solution {

    /**
     * 在一个不重复的数组里找峰值元素，我们可以考虑一直往某个高处走，最终一定会走到某个峰值位置
     * 因此我们可以复用A0153_FindMinimumInRotatedSortedArray中的方法，每次拆成左右两部分，然后一直试图找到一个更高的点往上走
     * 则找到的点一定是某个峰值
     *
     * 时间复杂度 : O(lgn).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 38.1 MB, 58.45%
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            final int leftMin = Math.max(nums[left], mid > 0 ? nums[mid - 1] : Integer.MIN_VALUE);
            final int rightMin = Math.max(nums[right], mid < nums.length ? nums[mid + 1] : Integer.MIN_VALUE);
            if (nums[mid] >= leftMin && nums[mid] >= rightMin) {
                return mid;
            } else if (leftMin > rightMin) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
