class Solution {
    Integer[] dp;

    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if(dp[i] != null) {
            return dp[i];
        }

        dp[i] = Math.max(dfs(nums, i + 1), dfs(nums, i + 2) + nums[i]);

        return dp[i];
    }

}
