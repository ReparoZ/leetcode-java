package problems.algorithms.A0153_FindMinimumInRotatedSortedArray;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * 示例 3：
 *
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * 
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/12/4
 */
public class Solution {

    /**
     * 通过二分法找到最小值，类似33搜索旋转排序数组，我们找到中点后，最小值一定靠近左右两段，端点最小的部分，因此只有两种情况
     * 1. 如果mid最小，则最小值为mid
     * 2. 如果nums[left]和nums[mid - 1]的最小值（也就是左段端点的最小值）小于nums[right]和nums[right + 1]的最小值，则最小值出现在左端中
     * 3. 否则最小值出现在右段中
     * 4. 将左段或者右端看做新的数组，重复上述流程
     *
     * 时间复杂度 : O(lgn).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 37.7 MB, 68.11%
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            final int leftMin = Math.min(nums[left], mid > 0 ? nums[mid - 1] : Integer.MAX_VALUE);
            final int rightMin = Math.min(nums[right], mid < nums.length ? nums[mid + 1] : Integer.MAX_VALUE);
            if (nums[mid] <= leftMin && nums[mid] <= rightMin) {
                return nums[mid];
            } else if (leftMin < rightMin) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
