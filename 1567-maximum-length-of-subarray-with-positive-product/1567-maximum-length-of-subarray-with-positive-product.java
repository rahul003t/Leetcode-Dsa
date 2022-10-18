class Solution {
    public int getMaxLen(int[] nums) {
        
        int positive=0,negative=0;
        int ans=0;
        
        for(int x : nums)
        {
            if(x ==0)
            {
                positive =0;
                negative =0;
            }
            else if(x >0)
            {
                positive++;
                negative = negative ==0 ? 0 : negative+1;
            }
            else
            {
                int temp=positive;
                positive = negative ==0 ? 0:negative+1;
                negative = temp+1;
            }
            
            ans = Math.max(ans,positive);
        }
        return ans;
    }
}