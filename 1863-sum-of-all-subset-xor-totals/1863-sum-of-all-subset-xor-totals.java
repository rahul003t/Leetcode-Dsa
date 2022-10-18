class Solution {
    public int subsetXORSum(int[] nums) {
        
       return  helper(nums,0,0);
        
    }
    
    int helper(int[] nums, int index, int currentXor)
    {
        if(nums.length == index )
        {
            return currentXor;
        }
        
        int withIndex = helper(nums, index+1 , currentXor ^ nums[index]);
        int withOutIndex = helper(nums , index+1 , currentXor);
        
        
        return withIndex + withOutIndex;
    }
}