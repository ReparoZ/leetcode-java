package problems.algorithms.A0389_FindTheDifference;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * 
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/18
 */
public class Solution {

    /**
     * 解 1：排序，排序后的字符串第一个不匹配的就是新增的字符
     *
     * 时间复杂度 : O(nlogn).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 3 ms, 44.67%
     * Memory Usage: 36.9 MB, 58.98%
     */
    public char findTheDifference1(String s, String t) {
        final char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        final char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        for (int i = 0; i < tChars.length; i++) {
            if (i >= sChars.length || tChars[i] != sChars[i]) {
                return tChars[i];
            }
        }

        throw new IllegalArgumentException("no solution.");
    }

    /**
     * 解 2：累加，由于只差一个字符，因此先加后减，最后剩下的肯定是多出来的字符
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 37.2 MB, 21.03%
     */
    public char findTheDifference2(String s, String t) {
        int result = 0;
        for (char tChar : t.toCharArray()) {
            result += tChar;
        }
        for (char sChar : s.toCharArray()) {
            result -= sChar;
        }

        return (char) result;
    }

    /**
     * 解 3：同解2，换成异或效果一样
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 36.9 MB, 61.90%
     */
    public char findTheDifference3(String s, String t) {
        int result = 0;
        for (char tChar : t.toCharArray()) {
            result ^= tChar;
        }
        for (char sChar : s.toCharArray()) {
            result ^= sChar;
        }

        return (char) result;
    }
}
