package testcase.algorithms.A1592_RearrangeSpacesBetweenWords;

import problems.algorithms.A1592_RearrangeSpacesBetweenWords.Solution;

/**
 * A1592_RearrangeSpacesBetweenWords
 *
 * @author reparo
 * @date 2022/9/8
 */
public class TestCase {

    public static void main(String[] args) {
        test("  this   is  a sentence ", "this   is   a   sentence");
        test(" practice   makes   perfect", "practice   makes   perfect ");
    }

    public static void test(String a, String expectedResult) {
        final String actualValue = new Solution().reorderSpaces(a);
        System.out.println(String.format("param is %s, ", a) +
                (actualValue.equals(expectedResult) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
