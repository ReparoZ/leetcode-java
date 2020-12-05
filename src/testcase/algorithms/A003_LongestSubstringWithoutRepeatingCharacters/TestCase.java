package testcase.algorithms.A003_LongestSubstringWithoutRepeatingCharacters;

import problems.algorithms.A003_LongestSubstringWithoutRepeatingCharacters.Solution;

/**
 * A003_LongestSubstringWithoutRepeatingCharacters
 *
 * @author steven.zmj
 * @date 2020/04/21
 */
public class TestCase {

    public static void main(String[] args) {
        test("", 0);
        test("abcabcbb", 3);
        test("bbbbb", 1);
        test("pwwkew", 3);
        test("abcdefg", 7);
        test("dvdf", 3);
    }

    public static void test(String a, int expectedResult) {
        final int actualValue = new Solution().lengthOfLongestSubstring2(a);
        System.out.println(String.format("param is %s, ", a) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
