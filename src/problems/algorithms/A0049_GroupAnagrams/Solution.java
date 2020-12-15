package problems.algorithms.A0049_GroupAnagrams;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/14
 */
public class Solution {

    /**
     * 解 1：本题唯一的难点就是如何判定字符串是否符合字母异位词，解一的方法就是单纯的计数法
     *
     * 时间复杂度 : O(n(k+∣Σ∣)).
     * 空间复杂度 : O(n(k+∣Σ∣)).
     *
     * 解答消耗参考:
     * Runtime: 59 ms, 8.00%
     * Memory Usage: 45.5 MB, 1.44%
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> charStringMap = new HashMap<>();
        for (String str : strs) {
            final Map<Character, Integer> charMap = new HashMap<>();
            for (char c : str.toCharArray()) {
                charMap.compute(c, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            }
            final List<String> stringList = charStringMap.computeIfAbsent(charMap, key -> new ArrayList<>());
            stringList.add(str);
        }

        return new ArrayList<>(charStringMap.values());
    }

    /**
     * 解 2：通过排序，排序后的字符相等的话，则为字母异位词
     *
     * 时间复杂度 : O(nklogn).
     * 空间复杂度 : O(nk).
     *
     * 解答消耗参考:
     * Runtime: 59 ms, 74.99%
     * Memory Usage: 45.5 MB, 99.98%
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        final Map<String, List<String>> charStringMap = new HashMap<>();
        for (String str : strs) {
            final char[] ca = str.toCharArray();
            Arrays.sort(ca);
            charStringMap.computeIfAbsent(new String(ca), key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(charStringMap.values());
    }
}
