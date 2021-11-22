package testcase.algorithms.A0070_ClimbingStairs;

import problems.algorithms.A0070_ClimbingStairs.Solution;

/**
 * A0070_ClimbingStairs
 *
 * @author reparo
 * @date 2021/11/23
 */
public class TestCase {

    public static void main(String[] args) {
        test(1, 1);
        test(2, 2);
        test(3, 3);
        test(4, 5);
    }

    private static void test(int n, int expectedResult) {
        final int actualValue = new Solution().climbStairs(n);
        System.out.println(String.format("param is %s, bad is %s", n, expectedResult) +
                (actualValue == expectedResult ? String.format(", result is %s, correct!", actualValue) :
                        String.format(", expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
