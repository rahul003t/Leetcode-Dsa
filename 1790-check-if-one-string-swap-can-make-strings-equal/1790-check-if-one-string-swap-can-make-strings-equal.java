class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
       int index=0,count=0;
        for(int i=0; i<s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
                count++;
                if(count == 1)
                {
                    index=i;
                }
                if(count ==2)
                {
                    if((s2.charAt(i) != s1.charAt(index)) || ((s1.charAt(i)) != s2.charAt(index)))
                    {
                        return false;
                    }
                }
            }
        }
        
        if(count ==0 || count ==2)
        {
            return true;
        }
        
        return false;
    }
    
   
}