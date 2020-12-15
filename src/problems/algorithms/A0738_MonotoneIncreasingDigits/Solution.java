package problems.algorithms.A0738_MonotoneIncreasingDigits;

import java.util.Arrays;

/**
 * 给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N是在[0, 10^9]范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/15
 */
public class Solution {

    /**
     * 解 1：对于任意一只位置的数，只有三种解法，要么前一位与原数字一致，则后续两种情况，本位置也一致，本位置比上一位少1
     * 如果前一位与比源数字少1，则后续都是9
     *
     * 时间复杂度 : O(logN)，N表示数字位数.
     * 空间复杂度 : O(logN).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 97.96%
     * Memory Usage: 35 MB, 97.17%
     */
    public int monotoneIncreasingDigits(int N) {
        final char[] nCharArr = Integer.toString(N).toCharArray();
        final char[] resultArr = new char[nCharArr.length];
        monotoneIncreasingDigits(nCharArr, resultArr, 0);
        return Integer.parseInt(new String(resultArr));
    }

    private boolean monotoneIncreasingDigits(final char[] nCharArr, final char[] resultArr, int pos) {
        if (pos == nCharArr.length) {
            return true;
        }

        if (pos > 0 && resultArr[pos - 1] != nCharArr[pos - 1]) {
            Arrays.fill(resultArr, pos, nCharArr.length, '9');
            return true;
        } else {
            for (int i = nCharArr[pos]; i >= nCharArr[pos] - 1 && (pos == 0 || i >= resultArr[pos - 1]) && i >= '0' ; i--) {
                resultArr[pos] = (char) i;
                final boolean valid = monotoneIncreasingDigits(nCharArr, resultArr, pos + 1);
                if (valid) {
                    return true;
                }
            }
        }

        return false;
    }
}
