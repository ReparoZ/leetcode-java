package problems.algorithms.A0003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 * 
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/05
 */
public class Solution {

    /**
     * 解 1: 滑动窗口模式，通过窗口的端点的调整，来确定不重复字符串的长度
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(字符集范围).
     *
     * 解答消耗参考:
     * Runtime: 7 ms, 82.00%
     * Memory Usage: 38.6 MB, 74.00%
     */
    public int lengthOfLongestSubstring1(String s) {
        final Map<Character, Integer> lastCharPosMap = new HashMap<>(s.length());
        int currLength = 0, maxLength = 0, lastNonRepeatPos = 0;
        final char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            final char currChar = chars[i];
            final Integer lastPos = lastCharPosMap.get(currChar);
            if (lastPos == null) {
                currLength++;
            } else if (lastPos < lastNonRepeatPos) {
                currLength++;
            } else {
                lastNonRepeatPos = lastPos + 1;
                maxLength = Math.max(maxLength, currLength);
                currLength = i - lastNonRepeatPos + 1;
            }

            lastCharPosMap.put(currChar, i);
        }

        return Math.max(maxLength, currLength);
    }

    /**
     * 解 2: 如果能确定字符串的字符范围的话，可以用数组代替Map，来确定不重复字符串的长度
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(字符集范围).
     *
     * 解答消耗参考:
     * Runtime: 3 ms, 92.00%
     * Memory Usage: 38.4 MB, 91.00%
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxNotDup = 0, lastNotDup = 0;
        int[] index = new int[128];
        for (int i = 0; i < s.length(); i++) {
            lastNotDup = Math.max(index[s.charAt(i)], lastNotDup);
            maxNotDup = Math.max(maxNotDup, i - lastNotDup + 1);
            index[s.charAt(i)] = i + 1;
        }
        return maxNotDup;
    }
}
