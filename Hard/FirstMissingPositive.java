// 41. First Missing Positive - 05.09.2024

class Solution {
    public int firstMissingPositive(int[] nums) {
        //missing integer will always be in range [1, nums.length]

        for(int i = 0; i < nums.length; i++) {
            //if nums[i] is in the range? move to front?
            if(1 <= nums[i] && nums[i] <= nums.length && nums[i] != i+1) {
                int temp = nums[nums[i]-1];
                if(temp == nums[i]) nums[i] = -1; //or -1?
                else if(1 <= temp && temp <= nums.length) {
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                    i--;
                } else {
                    nums[nums[i]-1] = nums[i];
                    nums[i] = -1;
                }

            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
}