class Solution {
     Integer[] dp;

    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int take = nums[index] + dfs(nums, index + 2);
        int skip = dfs(nums, index + 1);

        int max = Math.max(take, skip);
        dp[index] = max;

        return dp[index];
    }
}
