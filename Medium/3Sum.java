// 15. 3Sum - 06.26.2025
import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        
        for(int i = 0; i < nums.length-2; i++) {

            if(nums[i] > 0) break;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length-1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0) {
                    Integer[] triple = new Integer[] {nums[i], nums[left], nums[right]};
                    triplets.add(Arrays.asList(triple));

                    int tempL = nums[left];
                    int tempR = nums[right];
                    while(nums[left] == tempL && left < right) left++;
                    while(nums[right] == tempR && right > left) right--;

                } else if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                }
            }
        }
        return triplets;
    }
}