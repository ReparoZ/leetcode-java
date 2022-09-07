package problems.algorithms.A1592_RearrangeSpacesBetweenWords;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 * <p>
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 * <p>
 * 返回 重新排列空格后的字符串 。
 * <p>
 * 
 *
 * 示例 1：
 * <p>
 * 输入：text = "  this   is  a sentence "
 * 输出："this   is   a   sentence"
 * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 * 示例 2：
 * <p>
 * 输入：text = " practice   makes   perfect"
 * 输出："practice   makes   perfect "
 * 解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
 * 示例 3：
 * <p>
 * 输入：text = "hello   world"
 * 输出："hello   world"
 * 示例 4：
 * <p>
 * 输入：text = "  walks  udp package   into  bar a"
 * 输出："walks  udp  package  into  bar  a "
 * 示例 5：
 * <p>
 * 输入：text = "a"
 * 输出："a"
 * <p>
 *
 * 提示：
 * <p>
 * 1 <= text.length <= 100
 * text 由小写英文字母和 ' ' 组成
 * text 中至少包含一个单词
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/rearrange-spaces-between-words">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/9/7
 */
public class Solution {

    /**
     * 正常逻辑，无难度
     * <p>
     * 时间复杂度 : O(n)
     * 空间复杂度 : O(n)
     * <p>
     * 解答消耗参考:
     * Runtime: 1 ms, 89.84%
     * Memory Usage: 39.3 MB, 91.75%
     */
    public String reorderSpaces(String text) {
        final List<String> wordList = new ArrayList<>();
        int lastSpace = -1, spaceCount = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                if (i - lastSpace > 1) {
                    wordList.add(text.substring(lastSpace + 1, i));
                }

                if (i != text.length()) {
                    spaceCount++;
                    lastSpace = i;
                }
            }
        }

        int spaceBetweenWord = wordList.size() == 1 ? 0 : spaceCount / (wordList.size() - 1);
        int spaceAfterAll = wordList.size() == 1 ? spaceCount : spaceCount % (wordList.size() - 1);

        final String spaceStr = " ".repeat(spaceBetweenWord);
        final String collect = String.join(spaceStr, wordList);
        return collect + " ".repeat(spaceAfterAll);
    }
}
