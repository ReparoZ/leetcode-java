package testcase.algorithms.A0007_ReverseInteger;

import problems.algorithms.A0007_ReverseInteger.Solution;

/**
 * A0007_ReverseInteger
 *
 * @author ml3426
 * @date 2020/12/13
 */
public class TestCase {

    public static void main(String[] args) {
        test(123, 321);
        test(-123, -321);
        test(120, 21);
    }

    public static void test(int a, int expectedResult) {
        final int actualValue = new Solution().reverse(a);
        System.out.println(String.format("param is %s, ", a) +
                (actualValue== expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
