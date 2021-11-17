package problems.algorithms.A0318_MaximumProductOfWordLengths;

/**
 * 给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 
 *
 * 示例1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16 
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4 
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0 
 * 解释: 不存在这样的两个单词。
 * 
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i]仅包含小写字母
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/17
 */
public class Solution {

    /**
     * 本题的关键是如何判断两个词之间有重复字母，
     * 可以使用位运算预处理每个单词，通过位运算操作判断两个单词是否有公共字母。
     * 26个字母，存在字母的哪一位设置为1，然后两个掩码取并为0即可说明无公共字母
     *
     * 时间复杂度 : O(L + n^2).
     * 空间复杂度 : O(L + n^2)
     *
     * 解答消耗参考:
     * Runtime: 11 ms, 51.25%
     * Memory Usage: 38.6 MB, 42.75%
     */
    public int maxProduct(String[] words) {
        final int[] masks = new int[words.length];
        for (int i = 0; i < masks.length; i++) {
            masks[i] = getMaskOfStr(words[i]);
        }

        int maxProd = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }

        return maxProd;
    }

    public int getMaskOfStr(final String word) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask |= 1 << (word.charAt(i) - 'a');
        }

        return mask;
    }
}
