package testcase.algorithms.A0118_PascalsTriangle;

import problems.algorithms.A0118_PascalsTriangle.Solution;
import testcase.utils.ParseUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A0118_PascalsTriangle
 *
 * @author steven.zmj
 * @date 2020/12/05
 */
public class TestCase {

    public static void main(String[] args) {
        test(5, new int[][] {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}});
    }

    private static void test(int rows, int[][] expectedResult) {
        final Solution solution = new Solution();
        final List<List<Integer>> actualValue = solution.generate(rows);
        System.out.println(String.format("param is %s, ", rows) +
                (actualValue.equals(ParseUtils.parse2DArray(expectedResult)) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
