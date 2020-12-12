package problems.algorithms.A0376_WiggleSubsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)是正负交替出现的。相反, [1,4,7,2,5]和[1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 * <p>
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 * <p>
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 * 进阶:
 * 你能否用O(n) 时间复杂度完成此题?
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/12
 */
public class Solution {

    /**
     * 解 1：摆动序列，也就是说这个序列里，每两个数字之间的大小关系，是相互交错的，
     * 通过简单的分析可知，这个序列里一定可以包含这个数组的第一个和最后一个元素，
     * 通过这个结论，我们可以分析每两个数字之间的增减关系，每次遇到增减关系变化时，
     * 则可以认定这个数一定在摆动序列中
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 36.0 MB, 72.75%
     */
    public int wiggleMaxLength1(int[] nums) {
        int upOrDown = 0, result = 0, lastCorner = 0, gap = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                lastCorner = nums[0];
                result++;
                continue;
            }

            if (nums[i] == nums[i - 1] && i != nums.length - 1) {
                gap++;
                continue;
            } else if (upOrDown == 0) {
                upOrDown = (nums[i] > lastCorner) ? 1 : -1;
                gap = 1;
                continue;
            }

            if ((nums[i] > nums[i - gap] ? -1 : 1) == upOrDown) {
                upOrDown = upOrDown == 1 ? -1 : 1;
                lastCorner = nums[i - 1];
                result++;
                gap = 1;
            }

            if (i == nums.length - 1 && nums[i] != lastCorner) {
                result++;
            }
        }

        return result;
    }

    /**
     * 解 2：再一次抽象解1的想法，其实如果我们把这个序列，以数组坐标为x轴，元素值为
     * y轴作图，其实就是求解这条曲线，每一个顶点（波峰，波谷）的数量
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 36.0 MB, 72.75%
     */
    public int wiggleMaxLength2(int[] nums) {
        int result = 0, lastXor = 0;
        for (int i = 0; i < nums.length; i++) {
            final int score;
            if (i == 0) {
                result++;
                lastXor = nums[0];
            } else if (i == nums.length - 1) {
                score = lastXor == nums[i] ? 0 : 1;
                if (score == 1 && nums[i] != lastXor) {
                    result++;
                }
            } else {
                score = (Integer.compare(lastXor, nums[i]) + Integer.compare(nums[i], nums[i + 1])) == 0 ? 1 : 0;
                if (score != 0 && nums[i] != lastXor) {
                    result++;
                    lastXor = nums[i];
                }
            }
        }

        return result;
    }
}
