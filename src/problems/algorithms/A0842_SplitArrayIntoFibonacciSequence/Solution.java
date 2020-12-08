package problems.algorithms.A0842_SplitArrayIntoFibonacciSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * 
 *
 * 提示：
 *
 * 1 <= S.length<= 200
 * 字符串 S 中只含有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/08
 */
public class Solution {

    /**
     * 解 1：由于斐波那契数列，只要确定第一个元素和第二个元素即可确认后续所有的
     * 数字，且由于给出限制是在Int范围内，因此第一个元素和第二个元素必定小于10位
     *
     * 时间复杂度 : O(nlog^2 C).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 36.4 MB, 54.75%
     */
    public List<Integer> splitIntoFibonacci(String S) {
        int maxLength = 10;
        for (int i = 1; i < maxLength; i++) {
            for (int j = 1; j < maxLength; j++) {
                final List<Integer> integers = checkIsFibonacci(S, 0, i, j, new ArrayList<>());
                if (integers != null) {
                    return integers;
                }
            }
        }

        return new ArrayList<>();
    }

    public List<Integer> checkIsFibonacci(final String sArray, final int startIndex, final int firstNumLength, final int secondNumLength, List<Integer> results) {
        if (startIndex + firstNumLength + secondNumLength >= sArray.length()) {
            return results.isEmpty() ? null : results;
        }

        final String firstString = sArray.substring(startIndex, startIndex + firstNumLength);
        final String secondString = sArray.substring(startIndex + firstNumLength, startIndex + firstNumLength + secondNumLength);
        final int firstInt = Integer.parseInt(firstString);
        final int secondInt = Integer.parseInt(secondString);
        if (results.isEmpty()) {
            results.add(firstInt);
            results.add(secondInt);
        }
        if ((firstString.startsWith("0") && firstString.length() != 1) || (secondString.startsWith("0") && secondString.length() != 1)) {
            return null;
        }

        final int nextInt = firstInt + secondInt;
        final String thirdString = Integer.toString(nextInt);
        if (sArray.substring(startIndex + firstNumLength + secondNumLength).startsWith(thirdString)) {
            results.add(nextInt);
            return checkIsFibonacci(sArray, startIndex + firstNumLength, secondNumLength, thirdString.length(), results);
        } else {
            return null;
        }
    }
}
