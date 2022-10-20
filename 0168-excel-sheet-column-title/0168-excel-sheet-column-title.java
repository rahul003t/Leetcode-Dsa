class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder result = new StringBuilder();
        
        while(columnNumber > 0)
        {
            columnNumber--;
            result.append((char)('A'+columnNumber%26));
            columnNumber /= 26;              
                          
            
        }
        
        result.reverse();
        return result.toString();                  
                          
                                            
    }
}