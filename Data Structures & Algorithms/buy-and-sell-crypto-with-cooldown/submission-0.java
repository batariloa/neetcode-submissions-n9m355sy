class Solution {
        int[][] dp;

    public int maxProfit(int[] prices) {

        dp = new int[prices.length][2];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(prices, 0, 1);
    }

    private int dfs(int[] prices, int i, int buying) {

        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][buying] != -1) {
            return dp[i][buying];
        }

        if (buying == 1) {
            int buy = dfs(prices, i + 1, 0) - prices[i];
            int cooldown = dfs(prices, i + 1, 1);
            dp[i][buying] = Math.max(buy, cooldown);
        } else {
            int sell = dfs(prices, i + 2, 1) + prices[i];
            int cooldown = dfs(prices, i + 1, 0);
            dp[i][buying] = Math.max(sell, cooldown);
        }

        return dp[i][buying];
    }
}
