// 71. Simplify Path - 05.29.2025
import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        StringBuilder simplified = new StringBuilder("");
        Stack<String> dirStack = new Stack<>();
        
        String[] dir = path.split("/");
        
        for(int i = 0; i < dir.length; i++) {
            // if not an empty string, add string and a / after
            if(dir[i].equals("..")) {
                if(!dirStack.isEmpty()) dirStack.pop();
            }
            else if(!dir[i].equals(".") && !dir[i].equals("")) {
                dirStack.push(dir[i]);
            }
        }

        if(dirStack.isEmpty()) return "/";

        while(!dirStack.isEmpty()) {
            simplified.insert(0, "/" + dirStack.pop());
        }

        return simplified.toString();
    }
}