class Solution {
    public boolean areNumbersAscending(String s) {
        
        int previousNum=0;
        for(String str: s.split(" "))
        {
            if(Character.isDigit(str.charAt(0)))
            {
                int num = Integer.parseInt(str);
                if(num <= previousNum)
                {
                    return false;
                }
                previousNum=num;
                
            }
           
        }
        
        return true;
    }
}