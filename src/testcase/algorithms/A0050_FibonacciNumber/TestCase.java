package testcase.algorithms.A0050_FibonacciNumber;

import problems.algorithms.A0050_FibonacciNumber.Solution;

/**
 * A050_FibonacciNumber
 *
 * @author ml3426
 * @date 2021/01/05
 */
public class TestCase {

    public static void main(String[] args) {
        test(2, 1);
        test(3, 2);
        test(4, 3);
        test(30, 832040);
    }

    public static void test(int a, int expectedResult) {
        final int actualValue = new Solution().fib(a);
        System.out.println(String.format("param is %s, ", a) +
                (actualValue== expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
