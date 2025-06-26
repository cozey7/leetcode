// 15. 3Sum - 06.25.2025
import java.util.*;

// This solution is not optimal and I know how to make it better (currently in progress)
class Solution {

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // custom hashset (override equals) - sort nums first

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> triplets = new HashSet<>();

        for(int i = 0; i < nums.length-2; i++) {
            
            Map<Integer, Pair> map = new HashMap<>();

            for(int j = i+1; j < nums.length; j++) {
                Pair p = map.get(nums[j]);

                if(p == null) {
                    map.put(-nums[i]-nums[j], new Pair(nums[i], nums[j]));
                }
                else {
                    triplets.add(Arrays.asList(p.x, p.y, nums[j]));
                    map.remove(nums[j]);
                }
            }
        }

        res.addAll(triplets);
        return res;
    }
}