class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        if(nums.length ==0){
            return 0;
        }
        
        int sum=nums[0];
        int maxSoFar=nums[0];
        int minSoFar=nums[0];
        int minTotal=nums[0];
        int maxTotal=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            int num = nums[i];
            
            maxSoFar = Math.max(num,maxSoFar+num);
            maxTotal = Math.max(maxTotal,maxSoFar);
            
            minSoFar = Math.min(num,minSoFar+num);
            minTotal = Math.min(minSoFar,minTotal);
            
            sum += num;
            
            
            
        }
        if(sum == minTotal)
        {
            return maxTotal;
        }
        return Math.max(sum-minTotal,maxTotal);
    }
}