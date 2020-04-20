package problems.algorithms.A003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author steven.zmj
 * @date 2020/04/21
 */
public class Solution {

    /**
     * Solution 1: Sliding Window, Always find the last not duplicated letter and calc the length between them.
     * Dup the last letter to simplify the code.
     *
     * Time complexity : O(N).
     * Space complexity : O(N).
     *
     * For reference only:
     * Runtime: 10 ms, 25.58%
     * Memory Usage: 39.8 MB, 12.27%
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            s += s.charAt(s.length() - 1);
        }
        final Map<Character, Integer> charCache = new HashMap<>();
        int lastNotDup = 0;
        int maxNotDup = 0;
        for (int i = 0; i < s.length(); i++) {
            final char curr = s.charAt(i);
            if ((charCache.containsKey(curr) && charCache.get(curr) >= lastNotDup)) {
                if (i - lastNotDup > maxNotDup) {
                    maxNotDup = i - lastNotDup;
                }

                lastNotDup = charCache.get(curr) + 1;
                if (s.length() - 2 - lastNotDup < maxNotDup) {
                    break;
                }
            }

            charCache.put(curr, i);
        }

        return maxNotDup;
    }

    /**
     * Solution2: Assuming string is append by ascii char, use char array instead of hashmap
     *
     * Time complexity : O(N).
     * Space complexity : O(N).
     *
     * For reference only:
     * Runtime: 2 ms, 99.74%
     * Memory Usage: 39.4 MB, 16.75%
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxNotDup = 0;
        int[] index = new int[128];
        int lastNotDup = 0;
        for (int i = 0; i < s.length(); i++) {
            lastNotDup = Math.max(index[s.charAt(i)], lastNotDup);
            maxNotDup = Math.max(maxNotDup, i - lastNotDup + 1);
            index[s.charAt(i)] = i + 1;
        }
        return maxNotDup;
    }
}
