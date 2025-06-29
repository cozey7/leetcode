// 76. Minimum Window Substring - 06.29.2025
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // hash table to keep track of how many times a character appears in t
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer x = map.get(c);

            if(x == null) map.put(c, 1);
            else map.put(c, x.intValue()+1);
        }

        // System.out.println(map);

        int charCount = t.length();
        int left = 0;
        int right = 0;
        String minWindow = null;
        boolean contains = false;   // whether current sliding window contains t

        while(right < s.length() || contains) {

            // increase right if subarray length is less than t.length
            if(right - left < t.length() || !contains) {
                Character c = s.charAt(right);
                Integer x = map.get(c);
                if(x != null) {
                    map.put(c, x.intValue()-1);
                    // change count of smth if x > 0
                    if(x.intValue() > 0) charCount--;
                }
                right++;
            }

            // increase left if all characters are found
            // if right - left < minWindow.length or null -> update 
            // increase until we reach a useful char ?
            if(contains) {
                Character c = s.charAt(left);
                Integer x = map.get(c);
                if(x != null) {
                    map.put(c, x.intValue()+1);
                    // change count of smth if x >= 0
                    if(x.intValue() >= 0) charCount++;
                }
                left++;
            }

            // update minWindow
            if(charCount == 0) {
                if(minWindow == null || right-left < minWindow.length()) {
                    minWindow = s.substring(left, right);
                }
                contains = true;
            }
            else contains = false;

            //System.out.println(map + ", ct=" + charCount);
        }
        if(minWindow == null) return "";
        return minWindow;
    }
}