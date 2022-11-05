import java.util.*;

class Solution {
    Trie dict;
    private char[][] board;
    private int m;
    private int n;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        dict = new Trie();
        for (String word : words) {
            dict.addWord(word);
        }
        this.board = board;
        m = board.length;
        n = board[0].length;

        result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit(i, j, dict);
            }
        }

        return result;
    }

    private void visit(int i, int j, Trie parentTrie) {
        if (board[i][j] == '#') return;
        char c = board[i][j];
        Trie trie = parentTrie.get(c);
        if (trie == null) return;
        board[i][j] = '#';

        if (trie.isWord()){
            result.add(trie.word);
         
            if(trie.children.size() == 0){
                // remove from trie
                parentTrie.children.remove(c);
            } else {
                 trie.word = null;
            }
        }

        if(i > 0){
            visit(i-1, j, trie);
        }
        if(i+1 < m){
            visit(i+1, j, trie);
        }
        if(j > 0){
            visit(i, j-1, trie);
        }
        if(j+1 < n) {
            visit(i, j + 1, trie);
        }

        // this is the part where we trim the trie
        if(trie.children.size() == 0) parentTrie.children.remove(c); 

        board[i][j] = c;
    }

    private static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        String word;

        public void addWord(String s) {
            Trie current = this;
            for (char c : s.toCharArray()) {
                Trie next = current.children.get(c);
                if (next == null) {
                    next = new Trie();
                    current.children.put(c, next);
                }

                current = next;
            }
            current.word = s;
        }

        public Trie get(char c) {
            return children.get(c);
        }

        public boolean isWord(){
            return word != null;
        }
    }

}