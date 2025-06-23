// 937. Reorder Data in Log Files - 05.27.2025
import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        CustomComparator myComp = new CustomComparator();

        Arrays.sort(logs, myComp);
        return logs;
    }
}

// Custom comparator to sort by
class CustomComparator implements Comparator<String> {

    public int compare(String str1, String str2) {
        String [] log1 = str1.split(" ", 2);
        String [] log2 = str2.split(" ", 2);

        if(isLL(log1) && isLL(log2)) {
            int comp = log1[1].compareTo(log2[1]);
            if(comp != 0) return comp;
            return log1[0].compareTo(log2[0]);
        } else if(isLL(log1)) return -1;
        else if(isLL(log2)) return 1;
        return 0;
        
    }

    private boolean isLL(String [] data) {
        return Character.isLetter(data[1].charAt(0));
    }


}