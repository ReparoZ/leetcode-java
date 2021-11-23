package testcase.algorithms.A0120_Triangle;

import problems.algorithms.A0120_Triangle.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0120_Triangle
 *
 * @author reparo
 * @date 2021/11/23
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}}, 11);
        test(new int[][]{{-10}}, -10);
    }

    public static void test(int[][] triangle, int expectedResult) {
        final List<List<Integer>> triangleList = ParseUtils.parse2DArray(triangle);
        final int actualValue = new Solution().minimumTotal(triangleList);
        System.out.println(String.format("param is %s ", triangleList) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
