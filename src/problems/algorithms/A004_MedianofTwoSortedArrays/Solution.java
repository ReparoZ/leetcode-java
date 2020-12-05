package problems.algorithms.A004_MedianofTwoSortedArrays;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * 
 * 提示：
 * <code>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * </code>
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author steven.zmj
 * @date 2020/12/05
 */
public class Solution {

    /**
     * 解 1：坐标法，通过层层比较，找到第N个元素
     *
     * 时间复杂度 : O(m+n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 3 ms, 82.00%
     * Memory Usage: 39.7 MB, 69.00%
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        final boolean isEvenLength = (nums1.length + nums2.length) % 2 == 0;
        final int middleOnePos = isEvenLength ? (nums1.length + nums2.length) / 2 - 1 : (nums1.length + nums2.length) / 2;
        int pos1 = 0, pos2 = 0;
        for (int i = 0; i < middleOnePos; i++) {
            final int num1 = getNumber(nums1, pos1);
            final int num2 = getNumber(nums2, pos2);
            if (num1 > num2) {
                pos2++;
            } else {
                pos1++;
            }
        }

        if (isEvenLength) {
            if (getNumber(nums1, pos1) < getNumber(nums2, pos2)) {
                return (getNumber(nums1, pos1) + Math.min(getNumber(nums1, pos1 + 1), getNumber(nums2, pos2))) / 2.0;
            } else {
                return (getNumber(nums2, pos2) + Math.min(getNumber(nums1, pos1), getNumber(nums2, pos2 + 1))) / 2.0;
            }
        } else {
            return Math.min(getNumber(nums1, pos1), getNumber(nums2, pos2));
        }
    }

    /**
     * 解 2：二分查找法
     * 原理：中位数左边的数字个数和右边的数字个数相等，并且左边的最大值小于右边的最小值
     * 在长数组上找到任意一个点区分左右两边，由于中位数性质，短数组上的对应的点和左右两边的数字也可以确定下来
     * 由于两个数组有序，因此通过二分法找到长数组上的那个点，也就可以确定短数组的点，从而确定中位数
     * 本题也可以改在短数组上操作，从而使时间复杂度变为O(log(min(m, n)))
     *
     * 时间复杂度 : O(log(m)).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 3 ms, 82.00%
     * Memory Usage: 39.7 MB, 69.00%
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
         if (nums1.length < nums2.length) {
             int[] temp = nums1;
             nums1 = nums2;
             nums2 = temp;
         }

         int totalLeft = (nums1.length + nums2.length + 1) / 2, leftPos = 0, rightPos = nums1.length;
         boolean isEvenLength = (nums1.length + nums2.length) % 2 == 0;
         while (leftPos <= rightPos) {
            final int middlePos = leftPos == rightPos ? leftPos - 1 : leftPos + (rightPos - leftPos) / 2;
            final int anotherMiddlePos = totalLeft - middlePos - 2;
            final int leftMax = Math.max(getNumber(nums1, middlePos), getNumber(nums2, anotherMiddlePos));
            final int rightMin = Math.min(getNumber(nums1, middlePos + 1), getNumber(nums2, anotherMiddlePos + 1));
            if (leftMax <= rightMin) {
                return isEvenLength ?  (leftMax + rightMin) / 2.0 : leftMax;
            } else if (getNumber(nums1, middlePos) > getNumber(nums2, anotherMiddlePos + 1)) {
                rightPos = middlePos;
            } else {
                leftPos = middlePos + 1;
            }
         }

         throw new IllegalArgumentException("no solution.");
    }

    public int getNumber(int[] nums, int index) {
        return index >= nums.length ? Integer.MAX_VALUE : index < 0 ? Integer.MIN_VALUE : nums[index];
    }
}
