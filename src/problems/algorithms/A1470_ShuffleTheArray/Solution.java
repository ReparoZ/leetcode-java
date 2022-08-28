package problems.algorithms.A1470_ShuffleTheArray;

/**
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7] 
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shuffle-the-array">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 双指针法，很简单，注意交界点和边界即可
     * <p>
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(n)
     * <p>
     * 解答消耗参考:
     * Runtime: 1 ms, 11.74%
     * Memory Usage: 41.3 MB, 78.99%
     */
    public int[] shuffle(int[] nums, int n) {
        final int[] result = new int[nums.length];
        int left = 0, right = n;
        boolean isLeft = true;

        for (int i = 0; i < nums.length; i++) {
            result[i] = isLeft || right >= nums.length ? nums[left] : nums[right];
            if (left + 1 > n) {
                isLeft = false;
                right++;
            } else if (right + 1 > nums.length) {
                isLeft = true;
                left++;
            } else if (isLeft) {
                isLeft = false;
                left++;
            } else {
                isLeft = true;
                right++;
            }
        }

        return result;
    }
}
