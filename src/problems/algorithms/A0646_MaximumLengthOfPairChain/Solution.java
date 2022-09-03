package problems.algorithms.A0646_MaximumLengthOfPairChain;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 *
 *
 * 示例：
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 * <p>
 *
 * 提示：
 * <p>
 * 给出数对的个数在[1, 1000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-length-of-pair-chain">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/9/3
 */
public class Solution {

    /**
     * 先排序，然后从序列从左往右来找到下一个能构成链的序列，要让链越长，则链的右边界应该更短
     * <p>
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(1)
     * <p>
     * 解答消耗参考:
     * Runtime: 19 ms, 48.19%
     * Memory Usage: 42.9 MB, 10.62%
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing(pair -> pair[0]));

        int result = 0;

        if (pairs.length != 0) {
            result++;
            int[] cur = pairs[0];
            for (final int[] pair : pairs) {
                if (pair[1] < cur[1]) {
                    cur = pair;
                } else if (pair[0] > cur[1]) {
                    result++;
                    cur = pair;
                }
            }
        }

        return result;
    }
}
