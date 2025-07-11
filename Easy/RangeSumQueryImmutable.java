// 303. Range Sum Query - Immutable - 05.28.2025
import java.util.*;

class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        System.out.println(Arrays.toString(sums));
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return sums[right];
        return sums[right] - sums[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */