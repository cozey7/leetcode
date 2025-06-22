// 2138. Divide a String Into Groups of Size k - 06.21.2025
package leetcode;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        double x = (double)(len)/k;
        String[] res = new String[(int)Math.ceil(x)];

        for(int i = 1; i < len+1; i++) {
            if(i%k == 0) res[i/k - 1] = s.substring(i-k, i);
        }

        if(len%k != 0) {
            String filler = Character.toString(fill).repeat(k-len%k);
            res[res.length-1] = s.substring(len-len%k, len).concat(filler);
        }

        return res;
    }
}