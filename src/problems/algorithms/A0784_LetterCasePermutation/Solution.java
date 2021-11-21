package problems.algorithms.A0784_LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例：
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入：S = "3z4"
 * 输出：["3z4", "3Z4"]
 * <p>
 * 输入：S = "12345"
 * 输出：["12345"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * S的长度不超过12。
 * S仅由数字和字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/21
 */
public class Solution {

    /**
     * 如果下一个子母是数字
     *
     * 时间复杂度 : O(2^N*N)，N表示S长度.
     * 空间复杂度 : O(2^N*N).
     *
     * 解答消耗参考:
     * Runtime: 14 ms, 11.64%
     * Memory Usage: 39.3 MB, 31.68%
     */
    public List<String> letterCasePermutation(String s) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                List<String> cur = new ArrayList<>();
                if (resultList.size() == 0) {
                    cur.add(Character.toUpperCase(s.charAt(i)) + "");
                    cur.add(Character.toLowerCase(s.charAt(i)) + "");
                } else {
                    for (String s1 : resultList) {
                        cur.add(s1 + Character.toUpperCase(s.charAt(i)));
                        cur.add(s1 + Character.toLowerCase(s.charAt(i)));
                    }
                }

                resultList = cur;
            } else {
                List<String> cur = new ArrayList<>();
                if (resultList.size() == 0) {
                    cur.add(s.charAt(i) + "");
                } else {
                    for (String s1 : resultList) {
                        cur.add(s1 + s.charAt(i));
                    }
                }
                resultList = cur;
            }
        }

        return resultList;
    }
}
