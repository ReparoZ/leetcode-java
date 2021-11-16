package testcase.algorithms.A0733_FloodFill;

import problems.algorithms.A0733_FloodFill.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0733_FloodFill
 *
 * @author reparo
 * @date 2021/11/17
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2, new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}});
        test(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 2, new int[][]{{2, 2, 2}, {2, 2, 2}});
    }

    public static void test(int[][] image, int sr, int sc, int newColor, int[][] expectedResult) {
        final List<List<Integer>> oriImage = ParseUtils.parse2DArray(image);
        final int[][] actualValue = new Solution().floodFill(image, sr, sc, newColor);
        final List<List<Integer>> actualImage = ParseUtils.parse2DArray(actualValue);
        final List<List<Integer>> expectedImage = ParseUtils.parse2DArray(expectedResult);
        System.out.println(String.format("param1 is %s, point is %s,%s, new color is %s, ", oriImage, sr, sc, newColor) +
                (actualImage.equals(expectedImage) ? String.format("result is %s, correct!", actualImage) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedImage, actualImage)));
    }
}
