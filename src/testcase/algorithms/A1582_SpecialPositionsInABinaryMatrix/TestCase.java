package testcase.algorithms.A1582_SpecialPositionsInABinaryMatrix;

import problems.algorithms.A1582_SpecialPositionsInABinaryMatrix.Solution;

import java.util.Arrays;

/**
 * A1582_SpecialPositionsInABinaryMatrix
 *
 * @author reparo
 * @date 2022/9/4
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}, 1);
        test(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, 3);
        test(new int[][]{{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}, 2);
        test(new int[][]{{0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}}, 3);
    }

    public static void test(int[][] mat, int expectedResult) {
        final int actualValue = new Solution().numSpecial(mat);
        System.out.println(String.format("param is %s ", Arrays.deepToString(mat)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
