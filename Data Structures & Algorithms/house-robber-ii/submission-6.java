class Solution {
      public int rob(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        return Math.max(dfs(nums, 0, nums.length - 2), dfs(nums, 1, nums.length-1));
      }

      private int dfs(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for(int i = start; i<=end ; i++) {

            int take = nums[i] + prev2;
            int skip = prev1;

            int max = Math.max(take, skip);

            prev2 = prev1;
            prev1 = max;            
        }

        return prev1;
      }
}
