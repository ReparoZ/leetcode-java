package problems.algorithms.A0316_RemoveDuplicateLetters;

import java.util.*;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/20
 */
public class Solution {

    /**
     * 解 1：贪心+栈来解决，需要注意的是，每次遍历一个字母时，我们首先看是否已经放入，如果已经有了忽略，如果没有并且栈比顶小，
     * 并且栈顶字母后面还会出现，那么我们弹出栈顶，并且设置栈顶元素没有放入，并继续遍历，接着我们判断当前字母是否在栈里面存在，
     * 如果存在那么就不需要放入了，但是要将次数减一，然后继续循环，如果没有那么设置已经存在，然后入栈。
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n)，N为可能的字符数，本题中为26.
     *
     * 解答消耗参考:
     * Runtime: 4 ms, 86.89%
     * Memory Usage: 38.4 MB, 70.99%
     */
    public String removeDuplicateLetters(String s) {
        final char[] sCharArray = s.toCharArray();
        final int[] remainCounts = new int[26];
        final boolean[] visitedCounts = new boolean[26];
        for (char sChar : sCharArray) {
            remainCounts[sChar - 'a']++;
        }

        final Stack<Character> resultStack = new Stack<>();
        for (char sChar : sCharArray) {
            if (visitedCounts[sChar - 'a']) {
                remainCounts[sChar - 'a']--;
                continue;
            }

            while (!resultStack.isEmpty() && resultStack.peek() > sChar && remainCounts[resultStack.peek() - 'a'] > 0) {
                final Character prevChar = resultStack.pop();
                visitedCounts[prevChar - 'a'] = false;
            }

            visitedCounts[sChar - 'a'] = true;
            remainCounts[sChar - 'a']--;
            resultStack.push(sChar);
        }

        final StringBuilder sb = new StringBuilder();
        for (Character character : resultStack) {
            sb.append(character);
        }

        return sb.toString();
    }
}
