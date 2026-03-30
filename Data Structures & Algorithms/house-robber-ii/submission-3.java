class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        return Math.max(dfsLinear(nums, 0, nums.length - 2), dfsLinear(nums, 1, nums.length - 1));
    }

    private int dfsLinear(int[] nums, int start, int end) {

        int result = 0;

        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            int current = nums[i];

            int take = prev2 + current;
            int skip = prev1;

            result = Math.max(take, skip);

            prev2 = prev1;
            prev1 = result;
        }

        return result;
    }
}
