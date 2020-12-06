package testcase.algorithms.A0861_ScoreAfterFlippingMatrix;


import problems.algorithms.A0861_ScoreAfterFlippingMatrix.Solution;
import testcase.utils.ParseUtils;

/**
 * A0118_PascalsTriangle
 *
 * @author steven.zmj
 * @date 2020/12/05
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][] {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}, 39);
        test(new int[][] {{0, 1}, {1, 1}}, 5);
    }

    private static void test(int[][] matrix, int expectedResult) {
        final Solution solution = new Solution();
        final int actualValue = solution.matrixScore1(matrix);
        System.out.println(String.format("param is %s, ", ParseUtils.parse2DArray(matrix)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
