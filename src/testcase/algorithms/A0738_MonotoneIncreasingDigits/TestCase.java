package testcase.algorithms.A0738_MonotoneIncreasingDigits;


import problems.algorithms.A0738_MonotoneIncreasingDigits.Solution;

/**
 * A0738_MonotoneIncreasingDigits
 *
 * @author ml3426
 * @date 2020/12/15
 */
public class TestCase {

    public static void main(String[] args) {
        test(0, 0);
        test(10, 9);
        test(120, 119);
        test(332, 299);
        test(1234, 1234);
    }

    public static void test(int a, int expectedResult) {
        final int actualValue = new Solution().monotoneIncreasingDigits(a);
        System.out.println(String.format("param is %s, ", a) +
                (actualValue== expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
