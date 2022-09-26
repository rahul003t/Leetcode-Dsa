class Solution {
    public boolean isPerfectSquare(int n) {
        
      
        
        
        if(n ==1 || n==0){
            return true;
        }
        
        
       int low =0;
        int high=n/2;
        long mid =0;
        
        while(low<=high){
            
            mid = high + (low-high)/2;
            if(mid*mid == n){
                return true;
            }
            
            if(mid *mid > n){
                high = (int)(mid - 1);
            }
            if(mid*mid <n){
                low = (int)(mid+1);
            }
            
        }
        return false;
        
    }
}