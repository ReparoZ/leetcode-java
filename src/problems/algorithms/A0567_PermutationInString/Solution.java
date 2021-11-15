package problems.algorithms.A0567_PermutationInString;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 10^4
 * s1 和 s2 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/16
 */
public class Solution {

    /**
     * 固定窗口大小滑动窗口，因为s1大小固定，因此用一个s1长度大小的窗口，然后比较每个窗口内的子母数量即可
     *
     * 时间复杂度 : O(CN) , C为字符串可能的字符集个数，N为S1长度.
     * 空间复杂度 : O(C), C为字符串可能的字符集个数.
     *
     * 解答消耗参考:
     * Runtime: 41 ms, 16.47%
     * Memory Usage: 38.7 MB, 16.63%
     */
    public boolean checkInclusion(String s1, String s2) {
        final Map<Character, Integer> s1CharMap = new HashMap<>();
        final Map<Character, Integer> s2CharMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1CharMap.compute(c, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }

        final int windowSize = s1.length();
        int start = -1, end = -1;
        while (end < s2.length() - 1) {
            s2CharMap.compute(s2.charAt(end + 1), (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            if (end - start == windowSize - 1 && start >= 0) {
                final Integer charCount = s2CharMap.get(s2.charAt(start));
                if (charCount == 1) {
                    s2CharMap.remove(s2.charAt(start));
                } else {
                    s2CharMap.put(s2.charAt(start), charCount - 1);
                }
            }

            if (s1CharMap.equals(s2CharMap)) {
                return true;
            }

            if (end - start == windowSize - 1) {
                start++;
            }
            end++;
        }

        return false;
    }
}
