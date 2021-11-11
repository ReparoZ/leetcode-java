package problems.algorithms.A0977_SquaresOfASortedArray;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * 
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/12
 */
public class Solution {

    /**
     * 双指针法，先把两个指针置为正负交界处，用一个指针指向负数部分，从后往前，另一个指向正数部分，从前往后
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 40.3 MB, 28.24%
     */
    public int[] sortedSquares(int[] nums) {
        int neg = -1, nonNeg = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg++;
            } else if (nonNeg == nums.length) {
                nonNeg = i;
            }
        }

        final int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if (neg == -1) {
                result[i] = nums[nonNeg] * nums[nonNeg];
                nonNeg++;
            } else if (nonNeg == nums.length) {
                result[i] = nums[neg] * nums[neg];
                neg--;
            } else {
                int curNonNeg = nums[nonNeg] * nums[nonNeg];
                int curNeg = nums[neg] * nums[neg];
                if (curNeg > curNonNeg) {
                    result[i] = curNonNeg;
                    nonNeg++;
                } else {
                    result[i] = curNeg;
                    neg--;
                }
            }
        }

        return result;
    }
}
