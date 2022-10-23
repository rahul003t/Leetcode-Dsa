class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[1690];
        nums[0]=1;
        int ugly=0,c2=0,c3=0,c5=0;
        
        for(int i=1;i<1690;i++)
        {
            nums[i] = Math.min(Math.min(nums[c2]*2, nums[c3]*3), nums[c5]*5);
            ugly = nums[i];
            
            if(ugly == nums[c2]*2)
            {
                c2++;
            }
            if(ugly == nums[c3]*3)
            {
                c3++;
            }
            if(ugly ==  nums[c5]*5)
            {
                c5++;
            }
        }
    
        return nums[n-1];
    
    }
}