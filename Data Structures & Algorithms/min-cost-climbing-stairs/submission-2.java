class Solution {
    Integer[] dp;

    public int minCostClimbingStairs(int[] cost) {

        dp = new Integer[cost.length + 1];

        return dfs(cost, -1);
    }

    private int dfs(int[] cost, int index) {

        if (index >= cost.length) {
            return 0;
        }

        if (index != -1 && dp[index] != null) {
            return dp[index];
        }

        int current = index == -1 ? 0 : cost[index];

        int min = current + Math.min(dfs(cost, index + 1), dfs(cost, index + 2));

        if (index != -1) {
            dp[index] = min;
        return dp[index];

        }

        return min;
    }
}
