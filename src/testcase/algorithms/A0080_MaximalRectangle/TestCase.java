package testcase.algorithms.A0080_MaximalRectangle;

import problems.algorithms.A0080_MaximalRectangle.Solution;
import testcase.utils.ParseUtils;

/**
 * A0080_MaximalRectangle
 *
 * @author reparo
 * @date 2021/07/15
 */
public class TestCase {

    public static void main(String[] args) {
        test(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '1'}}, 6);
        test(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '0', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}, 5);
    }

    public static void test(final char[][] input, int expectedResult) {
        final int actualValue = new Solution().maximalRectangle(input);
        System.out.println(String.format("param is %s, ", ParseUtils.parse2DArray(input)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
