// 213. House Robber II - 06.23.2025

class Solution {
    public int rob(int[] nums) {
        // Max of House Robber I of two copies of nums (one without the last house and one without the first house)

        int[] loot1 = new int[nums.length];
        int[] loot2 = new int[nums.length];

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        loot1[0] = nums[0];
        loot1[1] = Math.max(nums[0], nums[1]);

        loot2[0] = 0;
        loot2[1] = nums[1];

        for(int i = 2; i < nums.length; i++) {
            
            loot1[i] = Math.max(loot1[i-2] + nums[i], loot1[i-1]);
            loot2[i] = Math.max(loot2[i-2] + nums[i], loot2[i-1]);

        }

        return Math.max(loot1[loot1.length-2], loot2[loot2.length-1]);
    }

}