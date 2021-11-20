package testcase.algorithms.A0994_RottingOranges;

import problems.algorithms.A0994_RottingOranges.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0994_RottingOranges
 *
 * @author reparo
 * @date 2021/11/20
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}, 4);
        test(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}, -1);
        test(new int[][]{{0, 2}}, 0);
    }

    private static void test(int[][] mat, int expectedResult) {
        final List<List<Integer>> oriMat = ParseUtils.parse2DArray(mat);
        final Solution solution = new Solution();
        final int actualResult = solution.orangesRotting(mat);
        System.out.println(String.format("param: %s, ", oriMat) +
                (actualResult == expectedResult ?
                        String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
