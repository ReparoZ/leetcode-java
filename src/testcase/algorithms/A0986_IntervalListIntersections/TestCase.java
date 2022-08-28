package testcase.algorithms.A0986_IntervalListIntersections;

import problems.algorithms.A0986_IntervalListIntersections.Solution;

import java.util.Arrays;

/**
 * A0986_IntervalListIntersections
 *
 * @author reparo
 * @date 2022/08/29
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}, new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}});
        test(new int[][]{{1, 3}, {5, 9}}, new int[][]{}, new int[][]{});
        test(new int[][]{}, new int[][]{{4, 8}, {10, 12}}, new int[][]{});
        test(new int[][]{{1, 7}}, new int[][]{{3, 10}}, new int[][]{{3, 7}});
        test(new int[][]{{1, 7}, {9, 10}, {19, 21}, {22, 23}}, new int[][]{{2, 20}}, new int[][]{{2, 7}, {9, 10}, {19, 20}});
    }

    public static void test(final int[][] firstList, final int[][] secondList, final int[][] expectedResult) {
        final int[][] actualValue = new Solution().intervalIntersection(firstList, secondList);
        System.out.println(String.format("param1 is %s, param2 is %s, ", Arrays.deepToString(firstList), Arrays.deepToString(secondList)) +
                (Arrays.deepEquals(actualValue, expectedResult) ? String.format("result is %s, correct!", Arrays.deepToString(actualValue)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", Arrays.deepToString(expectedResult), Arrays.deepToString(actualValue))));
    }
}
