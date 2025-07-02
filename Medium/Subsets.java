// 78. Subsets - 07.01.2025
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        choose(subsets, new ArrayList<>(), nums, 0);

        return subsets;

    }

    private void choose(List<List<Integer>> subsets, List<Integer> l, int[] nums, int i) {

        if(i == nums.length) {
            subsets.add(l);
            return;
        }

        // Choose to add the integer or not (2^n)
        List<Integer> clone = new ArrayList<>(l);
        clone.add(nums[i]);
        choose(subsets, l, nums, i+1);
        choose(subsets, clone, nums, i+1);
    }
}