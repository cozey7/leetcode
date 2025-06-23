// 53. Maximum Subarray - 06.15.2025

class Solution {
    public int maxSubArray(int[] nums) {

        int best = nums[0];
        int prev = nums[0];
        int curr;
        
        for(int i = 1; i < nums.length; i++) {
            curr = Math.max(prev+nums[i], nums[i]);
            best = Math.max(best, curr);
            prev = curr;
        }

        return best;
    }
}