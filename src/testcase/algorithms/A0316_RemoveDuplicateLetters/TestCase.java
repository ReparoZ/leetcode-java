package testcase.algorithms.A0316_RemoveDuplicateLetters;

import problems.algorithms.A0316_RemoveDuplicateLetters.Solution;

/**
 * A0316_RemoveDuplicateLetters
 *
 * @author ml3426
 * @date 2020/12/20
 */
public class TestCase {

    public static void main(String[] args) {
        test("bcabc", "abc");
        test("cbacdcbc", "acdb");
    }

    public static void test(String a, String expectedResult) {
        final String actualValue = new Solution().removeDuplicateLetters(a);
        System.out.println(String.format("param is %s, ", a) +
                (actualValue.equals(expectedResult) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
