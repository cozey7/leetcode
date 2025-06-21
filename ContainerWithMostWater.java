// 11. Container With Most Water - 06.11.2025
package leetcode;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = right * Math.min(height[left], height[right]);

        while(left != right) {
            if(height[left] < height[right]) left++;
            else right--;
            maxArea = Math.max(maxArea, (right-left) * Math.min(height[left], height[right]));
        }

        return maxArea;
    }
}