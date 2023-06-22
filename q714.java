/* question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/


Approach
DP
Beware states cannot exceed limit

Complexity

Time complexity:
O(n) -> state size depends on len(prices) only. "buy" has 2 possibilities only. 2n = n in tc calculation.

Space complexity:
O(n) -> cache size
 */

class Solution {
    int[] prices;
    int fee;
    Map<String, Integer> cache;
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        this.cache = new HashMap<>();

        return dp(0, true);
    }

    public int dp(int i, boolean buy) {
        String key = Integer.toString(i) + Boolean.toString(buy);
        if (i == prices.length) return 0;
        if (cache.containsKey(key)) return cache.get(key);

        int res = 0;
        if (buy) {
            // buy
            res = Math.max(res, dp(i + 1, !buy) - prices[i]);
            // skip
            res = Math.max(res, dp(i + 1, buy));
        } else {
            // sell
            res = Math.max(res, dp(i + 1, !buy) + prices[i] - fee);
            // skip
            res = Math.max(res, dp(i + 1, buy));
        }

        cache.put(key, res);

        return cache.get(key);
    }
}