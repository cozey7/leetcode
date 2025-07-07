// 208. Implement Trie (Prefix Tree) - 07.06.2025
class Trie {

    Trie[] children;
    boolean hasEnd;

    public Trie() {
        children = new Trie[26];
        hasEnd = false;
    }
    
    public void insert(String word) {
        if(word.length() == 0) {
            hasEnd = true;
            return;
        }

        char c = word.charAt(0);
        if(children[c - 'a'] == null) {
            children[c - 'a'] = new Trie();
        } 
        children[c - 'a'].insert(word.substring(1));
    }
    
    public boolean search(String word) {
        if(word.length() == 0) return hasEnd;

        char c = word.charAt(0);
        if(children[c - 'a'] == null) return false;
        
        return children[c - 'a'].search(word.substring(1));
    }
    
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return true;

        char c = prefix.charAt(0);
        if(children[c - 'a'] == null) return false;
        
        return children[c - 'a'].startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */