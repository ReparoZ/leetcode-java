package problems.algorithms.A0189_RotateArray;

/**
 * 给你一个数组，将数组中的元素向右轮转 k个位置，其中k是非负数。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释: 
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * 
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/12
 */
public class Solution {

    /**
     * 解 1：原地法，位移K位后，其实可以把数组拆成两个连续的部分倒置，再整体倒置，例如原数组
     * [1, 2, 3, 4, 5, 6, 7]，位移三位
     * [5, 6, 7, 1, 2, 3, 4]，可以看做是两个部分[5, 6, 7]和[1, 2, 3, 4]
     * 在原数组中先分别倒置
     * [4, 3, 2, 1, 7, 6, 5]，再整体倒置
     * [5, 6, 7, 1, 2, 3, 4] 即为答案
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 55.2 MB, 74.69%
     */
    public void rotate(int[] nums, int k) {
        final int realK = k % nums.length;
        reverse(nums, 0, nums.length - 1 - realK);
        reverse(nums, nums.length - realK, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}