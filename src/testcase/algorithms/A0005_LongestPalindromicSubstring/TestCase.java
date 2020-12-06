package testcase.algorithms.A0005_LongestPalindromicSubstring;

import problems.algorithms.A0005_LongestPalindromicSubstring.Solution;

/**
 * A0005_LongestPalindromicSubstring
 *
 * @author ml3426
 * @date 2020/12/06
 */
public class TestCase {

    public static void main(String[] args) {
//        test("b", "b");
//        test("babad", "bab");
        test("cbbd", "bb");
    }

    public static void test(String a, String expectedResult) {
        final String actualValue = new Solution().longestPalindrome(a);
        System.out.println(String.format("param is %s, ", a) +
                (actualValue.equals(expectedResult) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
