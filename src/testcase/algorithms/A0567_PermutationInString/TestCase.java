package testcase.algorithms.A0567_PermutationInString;

import problems.algorithms.A0567_PermutationInString.Solution;

/**
 * A0567_PermutationInString
 *
 * @author reparo
 * @date 2021/11/16
 */
public class TestCase {

    public static void main(String[] args) {
        test("a", "b", false);
        test("ab", "ab", true);
        test("ab", "ba", true);
        test("ab", "eidbaooo", true);
        test("ab", "eidbaooo", true);
    }

    public static void test(String s1, String s2, boolean expectedResult) {
        final boolean actualValue = new Solution().checkInclusion(s1, s2);
        System.out.println(String.format("param1 is \"%s\", param2 is \"%s\", ", s1, s2) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
