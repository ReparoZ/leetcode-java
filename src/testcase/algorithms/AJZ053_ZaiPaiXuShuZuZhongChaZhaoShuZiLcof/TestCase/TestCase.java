package testcase.algorithms.AJZ053_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof.TestCase;

import problems.algorithms.AJZ053_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof.Solution;

import java.util.Arrays;

/**
 * AJZ053_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof
 *
 * @author steven.zmj
 * @date 2020/12/05
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{5, 7, 7, 8, 8, 10}, 8, 2);
        test(new int[]{5, 7, 7, 8, 8, 10}, 6, 0);
    }

    private static void test(int[] matrix, int target, int expectedResult) {
        final Solution solution = new Solution();
        final int actualValue = solution.search2(matrix, target);
        System.out.println(String.format("param is %s and %s, ", Arrays.toString(matrix), target) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
