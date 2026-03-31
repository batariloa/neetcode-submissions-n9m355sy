class Solution {
public int lengthOfLIS(int[] nums) {
    Integer[][] memo = new Integer[nums.length][nums.length + 1];
    return helper(nums, 0, -1, memo);
}

private int helper(int[] nums, int index, int prevIndex, Integer[][] dp) {

    if(index >= nums.length) {
        return 0;
    }

    if(dp[index][prevIndex + 1] != null) {
        return dp[index][prevIndex+1];
    }

    int notTake = helper(nums, index + 1, prevIndex, dp);

    int take = 0;

    if(prevIndex == -1 || nums[index] > nums[prevIndex]) {
        take = 1 + helper(nums, index + 1, index, dp);
    }

    int max = Math.max(notTake, take);
    dp[index][prevIndex+1] = max;
    return max;
}
    
}
