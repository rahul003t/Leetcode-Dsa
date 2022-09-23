class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
     
        int low =1;
        int high = Integer.MAX_VALUE;
        
        while(low< high){
            int mid = low + (high -low)/2;
            int sum=0;
            
            for(int n: nums){
                sum+=Math.ceil(1.0 *n /mid); 
            }
            if(sum > threshold ){
                low = mid+1;
            }else{
                high= mid;
            }
        }
        return low;
    }
}