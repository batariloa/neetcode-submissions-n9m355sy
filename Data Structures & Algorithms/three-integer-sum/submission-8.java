class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++) {
            
            int curr = nums[i];

            if(curr>0) {
                break;
            }

            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int a = i + 1;
            int b = nums.length - 1;

            while(a < nums.length && a < b) {
                if(curr + nums[a] + nums[b] == 0) {
                    result.add(List.of(curr, nums[a], nums[b]));
                    while(a < b && nums[a] == nums[a+1]) a++;
                    while(a < b && nums[b] == nums[b-1]) b--;
                    a++;
                    b--;
                } 
                else if(curr + nums[a] + nums[b] > 0) {
                    b--;
                } else {
                    a++;
                }
            }
        }

        return result;
    }
}
