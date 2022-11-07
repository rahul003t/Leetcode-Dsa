class Solution {
    public int arraySign(int[] nums) {
     
        boolean isPositive=true;
        for(int i : nums)
        {
           if( i==0 )
           {
               return 0;
           }
            else if(i < 0)
            {
                isPositive = !isPositive; 
            }
            
        }
        
        return isPositive ? 1: -1;        
        
            
        }
}