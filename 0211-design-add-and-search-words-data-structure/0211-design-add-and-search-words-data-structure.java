class WordDictionary {

    ArrayList<String> list;

    public WordDictionary() {
        list = new ArrayList<>();
    }
    
    public void addWord(String word) {
        list.add(word);
    }
    
    public boolean search(String word) {
        
        for(int i = 0 ; i < list.size() ;i++)
        {
            if(check(list.get(i),word))
                return true;
        }

        return false;
    }

    public boolean check(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        
        for(int i = 0 ; i < s1.length() ;i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
                if(s1.charAt(i) != '.')
                {
                    if(s2.charAt(i) != '.')
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */