class Solution {
    public boolean checkIfPangram(String sentence) {
        
        if(sentence.length() < 26)
        {
            return false;
        }
        
        for(char i='a';i<='z';i++)
        {
            if(sentence.indexOf(i) == -1)
            {
                return false;
            }
        }
        return true;
        
    }
}