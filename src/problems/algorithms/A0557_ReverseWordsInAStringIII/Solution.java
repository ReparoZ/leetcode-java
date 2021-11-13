package problems.algorithms.A0557_ReverseWordsInAStringIII;

/**
 * @author reparo
 * @date 2021/11/13
 */
public class Solution {

    /**
     * 数组反序，无难度，注意别忘了翻转最后一个词即可
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 3 ms, 94.94%
     * Memory Usage: 39.1 MB, 45.59%
     */
    public String reverseWords(String s) {
        final char[] chars = s.toCharArray();
        int start = -1, end;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && start == -1) {
                start = i;
            } else if (chars[i] == ' ' && start != -1) {
                end = i - 1;
                reverse(chars, start, end);
                start = -1;
            }
        }

        if (start != -1) {
            reverse(chars, start, chars.length - 1);
        }

        return new String(chars);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
