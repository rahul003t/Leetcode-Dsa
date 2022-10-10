class Solution {
    public int findMin(int[] nums) {
        
        int low=0;
        int high = nums.length-1;
        int min = nums[0];
        
        while(low<=high){
            
            int mid = low+(high - low)/2;
            if(nums[low] == nums[high]){
                if(nums[low] <  min){
                    min = nums[low];
                }
                high = high -1;
                low = low+1;
            }
            
            else if(nums[low] <= nums[mid]){
                
                if(nums[low] < min){
                    min = nums[low];
                }
                low = mid+1;
            }
            else{
                if(nums[mid] < min){
                    
                    min = nums[mid];
                }
                high = mid-1;
            }
        }
        return min;
    }
}