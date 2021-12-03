package testcase.algorithms.A0074_SearchA2dMatrix;

import problems.algorithms.A0074_SearchA2dMatrix.Solution;
import testcase.utils.ParseUtils;

/**
 * A0074_SearchA2dMatrix
 *
 * @author reparo
 * @date 2021/12/4
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{1}}, 2, false);
        test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3, true);
        test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13, false);
    }

    private static void test(int[][] matrix, int target, boolean expectedResult) {
        final boolean actualValue = new Solution().searchMatrix(matrix, target);
        System.out.println(String.format("param is %s, target: %s, ", ParseUtils.parse2DArray(matrix), target) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
