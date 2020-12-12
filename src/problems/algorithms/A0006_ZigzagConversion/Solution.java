package problems.algorithms.A0006_ZigzagConversion;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows =4
 * 输出:"LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/07
 */
public class Solution {

    /**
     * 解 1：对于排列后的字符按行来进行处理，先拼接第一行，再拼接第二行如此循环
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 6 ms, 79.00%
     * Memory Usage: 39.2 MB, 74.00%
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        final List<StringBuilder> convertedRows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            convertedRows.add(new StringBuilder());
        }

        final char[] chars = s.toCharArray();
        final int oneZigLength = numRows * 2 - 2;
        for (int i = 0; i < chars.length; i++) {
            int zigPos = i % oneZigLength;
            if (zigPos >= numRows) {
                zigPos = (i - (zigPos + 1 - numRows) * 2) % oneZigLength;
            }

            convertedRows.get(zigPos).append(chars[i]);
        }

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(convertedRows.get(i));
        }

        return result.toString();
    }
}
