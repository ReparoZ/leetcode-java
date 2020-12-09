package testcase.algorithms.A0062_UniquePaths;

import problems.algorithms.A0062_UniquePaths.Solution;

import java.util.Arrays;

/**
 * A0062_UniquePaths
 *
 * @author ml3426
 * @date 2020/12/09
 */
public class TestCase {

    public static void main(String[] args) {
        test(3, 2, 3);
        test(7, 3, 28);
        test(12, 9, 75582);
        test(13, 23, 548354040);
    }

    private static void test(int m, int n, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.uniquePaths4(m, n);
        System.out.println(String.format("param1: %s, param2: %s, ", m, n) + (expectedResult == actualResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
