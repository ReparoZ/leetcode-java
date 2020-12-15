package problems.algorithms.A0290_WordPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设pattern只包含小写字母，str包含了由单个空格分隔的小写字母。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/16
 */
public class Solution {

    /**
     * 解 1：双向Map解决对应关系
     *
     * 时间复杂度 : O(n + m).
     * 空间复杂度 : O(n + m).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 35.2 MB, 74.75%
     */
    public boolean wordPattern(String pattern, String s) {
        final char[] chars = pattern.toCharArray();
        final String[] strings = s.split(" ");
        final Map<Character, String> aMap = new HashMap<>();
        final Map<String, Character> bMap = new HashMap<>();
        if (chars.length != strings.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!aMap.containsKey(chars[i]) && !bMap.containsKey(strings[i])) {
                aMap.put(chars[i], strings[i]);
                bMap.put(strings[i], chars[i]);
            } else if (!Objects.equals(aMap.get(chars[i]), strings[i]) || bMap.get(strings[i]) != chars[i]) {
                return false;
            }
        }

        return true;
    }
}
