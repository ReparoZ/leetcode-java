package problems.algorithms.A0520_DetectCapital;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写，比如"Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 *
 * 输入：word = "FlaG"
 * 输出：false
 * 
 *
 * 提示：
 *
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/13
 */
public class Solution {

    /**
     * 要么全大写，要么全小写，要么首字母大写，按条件判断即可
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 98.19%
     * Memory Usage: 37.0 MB, 9.42%
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        final char[] chars = word.toCharArray();
        if (Character.isUpperCase(chars[0])) {
            final boolean isUpper = Character.isUpperCase(chars[1]);
            for (int i = 2; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i]) != isUpper) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
