class Solution {
    public static int missingNumber(int[] nums)
    {

        int[] all = new int[nums.length + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            all[i] = i;
        }

        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }

        for (int j : all) {
            num ^= j;
        }

        return num;
    }
}
