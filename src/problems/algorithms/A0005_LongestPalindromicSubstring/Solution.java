package problems.algorithms.A0005_LongestPalindromicSubstring;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/06
 */
public class Solution {

    /**
     * 解 1：
     */
    public String longestPalindrome(String s) {
        String maxPalindrome = "";
        for (int i = 0; i < s.length() * 2; i++) {
            int leftPointer = i / 2, rightPointer = (i + 1) / 2, currentLength = rightPointer - leftPointer - 1;
            while (leftPointer >= 0 && rightPointer < s.length()) {
                if (s.charAt(leftPointer) == s.charAt(rightPointer)) {
                    leftPointer--;
                    rightPointer++;
                    currentLength += 2;
                } else {
                    break;
                }
            }

            if (currentLength > maxPalindrome.length()) {
                maxPalindrome = s.substring(leftPointer + 1, rightPointer);
            }
        }

        return maxPalindrome;
    }
}
