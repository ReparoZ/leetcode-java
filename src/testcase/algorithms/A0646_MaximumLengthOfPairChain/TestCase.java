package testcase.algorithms.A0646_MaximumLengthOfPairChain;

import problems.algorithms.A0646_MaximumLengthOfPairChain.Solution;

import java.util.Arrays;

/**
 * A0646_MaximumLengthOfPairChain
 *
 * @author reparo
 * @date 2021/11/18
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[][]{{1, 2}, {2, 3}, {3, 4}}, 2);
    }

    public static void test(int[][] pairs, int expectedResult) {
        final int actualValue = new Solution().findLongestChain(pairs);
        System.out.println(String.format("param is %s ", Arrays.deepToString(pairs)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
