package testcase.algorithms.A0542_01Matrix;

import problems.algorithms.A0542_01Matrix.Solution;
import testcase.utils.ParseUtils;

import java.util.Arrays;

/**
 * A0542_01Matrix
 *
 * @author reparo
 * @date 2021/11/20
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        test(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}});
    }

    private static void test(int[][] mat, int[][] expectedResult) {
        final Solution solution = new Solution();
        final int[][] actualResult = solution.updateMatrix(mat);
        System.out.println(String.format("param: %s, ", ParseUtils.parse2DArray(mat)) + (Arrays.deepEquals(actualResult, expectedResult) ?
                String.format("correct! result is %s", ParseUtils.parse2DArray(actualResult)) : String.format("Failed! expectedResult is %s, actualResult is %s.", ParseUtils.parse2DArray(expectedResult), ParseUtils.parse2DArray(actualResult))));
    }
}
