package problems.algorithms.A0714_BestTimeToBuyAndSellStockWithTransactionFee;

/**
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/19
 */
public class Solution {

    /**
     * 解 1：动态规划，将每一天分为手上持有股票，和股票已卖出两种状况，
     * 假设持有股票为Hold，卖出为Sell，则存在以下关系
     * holds[i] = Math.max(sells[i - 1] - prices[i], holds[i - 1]); // 要么继续持有，要么今天买入
     * sells[i] = Math.max(holds[i - 1] + prices[i] - fee, sells[i - 1]); // 要么继续观望，要么卖出
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 6 ms, 54.97%
     * Memory Usage: 48.8 MB, 5.01%
     */
    public int maxProfit(int[] prices, int fee) {
        final int[] sells = new int[prices.length];
        final int[] holds = new int[prices.length];
        sells[0] = 0; holds[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            holds[i] = Math.max(sells[i - 1] - prices[i], holds[i - 1]);
            sells[i] = Math.max(holds[i - 1] + prices[i] - fee, sells[i - 1]);
        }

        return sells[prices.length - 1];
    }
}
