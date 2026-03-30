class Solution {
    int[][] dp;

    public int change(int amount, int[] coins) {

        dp = new int[coins.length + 1][amount + 1];

        for(int[] arr: dp) {
        Arrays.fill(arr, -1);
        }

        dp[0][0] = 0;
        
        return dfs(coins, 0, amount);
    }

    private int dfs(int[] coins, int index, int amount) {
        
        if(amount == 0) {
            return 1;
        }

        if(index >= coins.length) {
            return 0;
        }

        if(amount < 0) {
            return 0;
        }

        if(dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int ways = dfs(coins, index, amount - coins[index]) 
        +dfs(coins, index + 1, amount);

        dp[index][amount] = ways;
        return dp[index][amount];
    }
 

}
