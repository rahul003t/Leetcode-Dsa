class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        HashSet<Integer> modSet= new HashSet<>();
        int currSum=0,prevSum=0;
        
        for(int i : nums)
        {
            currSum += i;
            if(modSet.contains(currSum%k))
            {
                return true;
            }
            
            currSum %= k;
            modSet.add(prevSum);
            prevSum = currSum;
        }
        
        return false;
    }
}