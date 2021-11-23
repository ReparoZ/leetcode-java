package testcase.algorithms.A0231_PowerOfTwo;

import problems.algorithms.A0231_PowerOfTwo.Solution;

/**
 * A0231_PowerOfTwo
 *
 * @author reparo
 * @date 2021/11/23
 */
public class TestCase {

    public static void main(String[] args) {
        test(-2147483648, false);
        test(0, false);
        test(1, true);
        test(16, true);
        test(3, false);
        test(4, true);
        test(5, false);
    }

    private static void test(int n, boolean expectedResult) {
        final boolean actualValue = new Solution().isPowerOfTwo(n);
        System.out.println(String.format("param is %s", n) +
                (actualValue == expectedResult ? String.format(", result is %s, correct!", actualValue) :
                        String.format(", expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
