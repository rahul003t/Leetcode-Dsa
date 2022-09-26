class Solution {
    public int triangleNumber(int[] nums) {
         int res = 0;
        Arrays.sort(nums);
        
        for(int i = 2; i<nums.length; i++){
            int low = 0;
            int low1 = i-1;
            while(low<low1){
                
            
            if(nums[low]+nums[low1]>nums[i]){
                res += low1-low;
                low1--;
            }else{
                low++;
            }
         }
        }    
        return res;
    }
}