// 1004. Max Consecutive Ones III - 05.28.2025
package leetcode;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, swapsUsed = 0;
        int maxCount = 0, currCount = 0;

        while(right < nums.length) {
            // Check right
            if(nums[right] == 0) {
                
                // Use a flip
                if(swapsUsed < k) {
                    swapsUsed++;
                    currCount++;
                }
                else {  // Move left
                    maxCount = Math.max(maxCount, currCount);
                    // Keep incrementing left until 0 found
                    while(nums[left] == 1) {
                        currCount--;
                        left++;
                    }
                    left++;
                }
            }
            else {  // nums[right] == 1
                currCount++;
            }
            
            right++;
            
        }

        return Math.max(maxCount, currCount);

    }
}