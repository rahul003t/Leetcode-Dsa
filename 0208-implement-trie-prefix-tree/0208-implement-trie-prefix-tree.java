class TrieNode {

HashMap<Character, TrieNode> children;
boolean endOfString;

TrieNode() {
    children = new HashMap<>();
    endOfString = false;
}
}

class Trie {

TrieNode root;
public Trie() {
    root = new TrieNode();
}

public void insert(String word) {
    
    TrieNode curr = root;
    for(int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        HashMap<Character, TrieNode> children = curr.children;
        if(children.get(ch) == null) {
            TrieNode newNode = new TrieNode();
            children.put(ch, newNode);
        }
        curr = children.get(ch);
    }
    curr.endOfString = true;
}

public boolean search(String word) {
    
    TrieNode curr = root;
    for(int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        HashMap<Character, TrieNode> children = curr.children;
        if(children.get(ch) == null) {
            return false;
        }
        curr = children.get(ch);
    }
    return curr.endOfString;
}

public boolean startsWith(String prefix) {
    
    TrieNode curr = root;
    for(int i = 0; i < prefix.length(); i++) {
        char ch = prefix.charAt(i);
        HashMap<Character, TrieNode> children = curr.children;
        if(children.get(ch) == null) {
            return false;
        }
        curr = children.get(ch);
    }
    return true;
    
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */