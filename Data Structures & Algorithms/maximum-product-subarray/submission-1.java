class Solution {

   
    public int maxProduct(int[] nums) {
     
     if(nums.length == 1) {
        return nums[0];
     }
     
    Integer[] dpMax = new Integer[nums.length + 1];
    Integer[] dpMin = new Integer[nums.length + 1];

    dpMax[nums.length] = 1;
    dpMax[nums.length - 1] = nums[nums.length - 1];

    dpMin[nums.length] = 1;
    dpMin[nums.length - 1] = nums[nums.length - 1];


    int resultMax = 0;

     for(int i = nums.length -1 ; i>=0; i--){

        int max = Math.max(Math.max(nums[i], nums[i] * dpMax[i+1]), nums[i] * dpMin[i + 1]);
        int min = Math.min(Math.min(nums[i], nums[i] * dpMax[i + 1]), nums[i] * dpMin[i+1]);

        dpMax[i] = max;
        dpMin[i] = min;

        resultMax = Math.max(resultMax, dpMax[i]);
     }

     return resultMax;
    }
}
