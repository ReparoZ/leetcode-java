package problems.algorithms.A0844_BackspaceStringCompare;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
 *
 * 如果相等，返回 true ；否则，返回 false 。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 “”。
 * 示例 3：
 *
 * 输入：s = "a##c", t = "#a#c"
 * 输出：true
 * 解释：s 和 t 都会变成 “c”。
 * 示例 4：
 *
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 “c”，但 t 仍然是 “b”。
 * 
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * 
 *
 * 进阶：
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/12/7
 */
public class Solution {

    /**
     * 双指针法，从两个字符串的末尾开始移动指针，每次遇到#，则需要跳过的正常字符数+1，直到跳过的次数为0，
     * 然后比较两个指针当前位置的字符，并且两个字符串在移动完之后，没有剩余的字符
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 62.93%
     * Memory Usage: 36.5 MB, 60.43%
     */
    public boolean backspaceCompare(String s, String t) {
        int point1 = s.length() - 1, point2 = t.length() - 1;
        while (point1 >= 0 || point2 >= 0) {
            int leftSharp = 0, rightSharp = 0;
            while (point1 >= 0 && (s.charAt(point1) == '#' || leftSharp > 0)) {
                if (s.charAt(point1) == '#') {
                    leftSharp++;
                } else {
                    leftSharp--;
                }

                point1--;
            }

            while (point2 >= 0 && (t.charAt(point2) == '#' || rightSharp > 0)) {
                if (t.charAt(point2) == '#') {
                    rightSharp++;
                } else {
                    rightSharp--;
                }

                point2--;
            }

            if (point1 >= 0 && point2 >= 0 && s.charAt(point1) != t.charAt(point2)) {
                return false;
            } else if ((point1 >= 0 && point2 < 0) || (point1 < 0 && point2 >= 0)) {
                return false;
            }

            point1--;
            point2--;
        }

        return true;
    }
}
