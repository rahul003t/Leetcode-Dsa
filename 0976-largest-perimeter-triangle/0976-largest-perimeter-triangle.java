class Solution {
    public int largestPerimeter(int[] nums) {
        
        int peri =0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            
            if(nums[i-1]+nums[i-2] > nums[i]){
                peri = nums[i]+nums[i-1]+nums[i-2];
                break;
            }
            
        }
        return peri;
        
        
    }
}