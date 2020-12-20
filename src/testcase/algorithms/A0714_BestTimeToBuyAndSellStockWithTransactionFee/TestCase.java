package testcase.algorithms.A0714_BestTimeToBuyAndSellStockWithTransactionFee;


import problems.algorithms.A0714_BestTimeToBuyAndSellStockWithTransactionFee.Solution;

import java.util.Arrays;

/**
 * A0714_BestTimeToBuyAndSellStockWithTransactionFee
 *
 * @author ml3426
 * @date 2020/12/19
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[] {1, 3, 2, 8, 4, 9}, 2, 8);
        test(new int[] {9, 8, 7, 1, 2}, 3, 0);
    }

    private static void test(int[] prices, int fee, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.maxProfit(prices, fee);
        System.out.println(String.format("param1: %s, param2: %s, ", Arrays.toString(prices), fee) + (expectedResult == actualResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
