package testcase.algorithms.A0048_RotateImage;

import problems.algorithms.A0048_RotateImage.Solution;
import testcase.utils.ParseUtils;

import java.util.Arrays;
import java.util.List;

/**
 * A0048_RotateImage
 *
 * @author ml3426
 * @date 2020/12/19
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
        test(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}, new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}});
        test(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}, new int[][]{{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}});
    }

    private static void test(int[][] matrix, int[][] expectedResult) {
        final Solution solution = new Solution();
        final List<List<Integer>> originParam = ParseUtils.parse2DArray(matrix);
        solution.rotate(matrix);
        System.out.println(String.format("param: %s, ", originParam) + (Arrays.deepEquals(expectedResult, matrix) ?
                String.format("correct! result is %s", originParam) : String.format("Failed! expectedResult is %s, actualResult is %s.", ParseUtils.parse2DArray(expectedResult), ParseUtils.parse2DArray(matrix))));
    }
}
