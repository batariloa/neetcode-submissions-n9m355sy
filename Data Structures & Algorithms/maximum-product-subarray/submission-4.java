class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 1) {
         return nums[0];
        }

        int[] dpMin = new int[nums.length + 1];
        int[] dpMax = new int[nums.length + 1];

        dpMin[nums.length] = 1;
        dpMax[nums.length] = 1;

        int result = 0;


         for(int i = nums.length - 1; i>= 0; i--) {

            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMax[i+1], nums[i] * dpMin[i+1]));
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i+1], nums[i] * dpMin[i+1]));

            result = Math.max(result, dpMax[i]);
         }
         

      return result;
    }
}
