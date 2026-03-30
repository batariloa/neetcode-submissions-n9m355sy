class Solution {
      public int rob(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        return Math.max(dfsLinear(nums, 0, nums.length - 2), dfsLinear(nums, 1, nums.length - 1));
    }
    private int dfsLinear(int[] nums, int start, int end) {

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        
        if(end - start >= 1) {
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = start + 2; i <= end; i++) {

            int current = nums[i];

            int take = current + dp[i - 2];
            int skip = dp[i - 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[end];
    }
}
