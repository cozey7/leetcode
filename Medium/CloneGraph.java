// 133. Clone Graph - 06.18.2025
import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        
        q.add(node);
        Node copy = new Node(node.val);
        map.put(node.val, copy);

        Node d, dCopy;
        while(!q.isEmpty()) {
            d = q.poll();
            dCopy = map.get(d.val);

            for(Node n : d.neighbors) {
                Node search = map.get(n.val);

                if(search == null) {
                    Node nCopy = new Node(n.val);
                    dCopy.neighbors.add(nCopy);
                    map.put(n.val, nCopy);
                    q.add(n);
                } else {
                    dCopy.neighbors.add(search);
                }
            }

        }
        return copy;
    }
}