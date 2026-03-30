class Solution {
    Integer[] dp;

    public int minCostClimbingStairs(int[] cost) {

        dp = new Integer[cost.length];

        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int index) {

        if (index >= cost.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int min = cost[index] + Math.min(dfs(cost, index + 1), dfs(cost, index + 2));

        dp[index] = min;
        return dp[index];
    }
}
