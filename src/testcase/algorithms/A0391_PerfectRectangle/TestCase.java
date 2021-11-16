package testcase.algorithms.A0391_PerfectRectangle;

import problems.algorithms.A0391_PerfectRectangle.Solution;
import testcase.utils.ParseUtils;

/**
 * A0391_PerfectRectangle
 *
 * @author reparo
 * @date 2021/11/17
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}, true);
        test(new int[][]{{1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4}}, false);
        test(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4}}, false);
        test(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}}, false);
    }

    public static void test(int[][] rectangles, boolean expectedResult) {
        final boolean actualValue = new Solution().isRectangleCover(rectangles);
        System.out.println(String.format("param is %s, ", ParseUtils.parse2DArray(rectangles)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}