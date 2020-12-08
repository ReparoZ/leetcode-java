package testcase.algorithms.ALCP01_GuessNumbers;


import problems.algorithms.ALCP01_GuessNumbers.Solution;

import java.util.Arrays;

/**
 * ALCP01_GuessNumbers
 *
 * @author ml3426
 * @date 2020/12/07
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[] {1, 2, 3}, new int[] {1, 2, 3}, 3);
        test(new int[] {1, 2, 3}, new int[] {2, 2, 1}, 1);
    }

    private static void test(int[] guess, int[] answer, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.game1(guess, answer);
        System.out.println(String.format("param1: %s, param2: %s, ", Arrays.toString(guess), Arrays.toString(answer)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", actualResult, expectedResult)));
    }
}
