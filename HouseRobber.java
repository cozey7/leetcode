// 198. House Robber - 05.29.2025
package leetcode;

class Solution {
    public int rob(int[] nums) {

        int[] loot = new int[nums.length];

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        loot[0] = nums[0];
        loot[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {

            // Max loot = max(max loot from two houses ago + curr, loot from previous)
            loot[i] = Math.max(loot[i-2] + nums[i], loot[i-1]);

        }

        return loot[loot.length-1];
    }
}