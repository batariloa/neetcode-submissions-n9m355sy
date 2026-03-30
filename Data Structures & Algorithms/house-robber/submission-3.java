class Solution {

    int[] dp;

    public int rob(int[] nums) {

        dp = new int[nums.length + 1];

        dp[nums.length - 1] = nums[nums.length -1];
        dp[nums.length] = 0;

        for(int i = nums.length - 2; i>=0; i--) {
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }

        return dp[0];
    }
}
