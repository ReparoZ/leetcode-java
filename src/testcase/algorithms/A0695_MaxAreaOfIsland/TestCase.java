package testcase.algorithms.A0695_MaxAreaOfIsland;

import problems.algorithms.A0695_MaxAreaOfIsland.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0695_MaxAreaOfIsland
 *
 * @author reparo
 * @date 2021/11/17
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}, 6);
        test(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}, 0);
    }

    public static void test(int[][] grid, int expectedResult) {
        final int actualValue = new Solution().maxAreaOfIsland(grid);
        final List<List<Integer>> gridImage = ParseUtils.parse2DArray(grid);
        System.out.println(String.format("param is %s ", gridImage) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
