public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int res = 0, minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return res;
    }
}