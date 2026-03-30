class Solution {
    public int minCostClimbingStairs(int[] cost) {

        Integer[] dp = new Integer[cost.length];

        return Math.min(dfs(cost, 0, dp), dfs(cost, 1, dp));

    }

    private int dfs(int[] cost, int index, Integer[] dp) {
        if (index >= cost.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int min = cost[index] + Math.min(dfs(cost, index + 1, dp),
                dfs(cost, index + 2, dp));

        dp[index] = min;
        return dp[index];
    }
}
