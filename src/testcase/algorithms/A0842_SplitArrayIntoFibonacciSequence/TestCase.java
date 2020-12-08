package testcase.algorithms.A0842_SplitArrayIntoFibonacciSequence;

import problems.algorithms.A0842_SplitArrayIntoFibonacciSequence.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0842_SplitArrayIntoFibonacciSequence
 *
 * @author ml3426
 * @date 2020/12/08
 */
public class TestCase {

    public static void main(String[] args) {
        test("123456579", new int[] {123, 456, 579});
        test("11235813", new int[] {1, 1, 2, 3, 5, 8, 13});
        test("112358130", new int[] {});
        test("0123", new int[] {});
        test("1101111", new int[] {11, 0, 11, 11});
    }

    private static void test(String s, int[] expectedResult) {
        final Solution solution = new Solution();
        final List<Integer> actualResult = solution.splitIntoFibonacci(s);
        System.out.println(String.format("param1: %s, ", s) + (actualResult.equals(ParseUtils.parseArray(expectedResult)) ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", ParseUtils.parseArray(expectedResult), actualResult)));
    }
}
