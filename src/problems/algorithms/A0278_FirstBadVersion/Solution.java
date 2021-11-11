package problems.algorithms.A0278_FirstBadVersion;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false 
 * 调用 isBadVersion(5)-> true 
 * 调用 isBadVersion(4)-> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 * 
 *
 * 提示：
 *
 * 1 <= bad <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/11/11
 */
public class Solution extends VersionControl {

    /**
     * 基础的二分，查找最后一个正确的版本的下一个版本，要注意到的是，算middle的时候，可能会超过int，因此需要转换成long
     *
     * 时间复杂度 : O(logn).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 12 ms, 39.36%
     * Memory Usage: 35.1 MB, 70.81%
     */
    public int firstBadVersion(int n) {
        long left = 1, right = n;
        if (n == 1) {
            return 1;
        }

        while (left < right) {
            final int middle = (int) ((left + right + 1) / 2);
            if (isBadVersion(middle)) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }

        return isBadVersion((int) right) ? 1 : (int) right + 1;
    }
}