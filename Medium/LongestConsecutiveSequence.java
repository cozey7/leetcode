// 128. Longest Consecutive Sequence - 06.14.2025
import java.util.*;

class Solution {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int maxConsecutive = 0;

        for(int n : set) {
            if(!set.contains(n-1)) {
                int m = n+1;
                while(set.contains(m)) m++;
                maxConsecutive = Math.max(maxConsecutive, m-n);
            }
        }

        return maxConsecutive;
            
    }
}