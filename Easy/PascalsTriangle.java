// 118. Pascal's Triangle - 05.21.2025
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        List<Integer> li = new ArrayList<>();
        li.add(1);
        pascal.add(li);

        int width;
        for(int i = 1; i < numRows; i++) {
            width = i+1;
            li = new ArrayList<>();
            
            for(int j = 0; j < width; j++) {
                if(j == 0 || j == width-1) li.add(1);   // sides are always 1
                else li.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j)); // sum of two nodes above
            }

            pascal.add(li);

        }
        return pascal;
    }
}