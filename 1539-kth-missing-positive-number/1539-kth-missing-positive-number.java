class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int n= arr.length;
        int left =0;
        int right=n-1;
        int missing= compute(arr[n-1],n);
        while(left <= right){
            int mid = left+(right-left)/2;
            missing = compute(arr[mid],mid+1);
            
            if(missing >=k)  right =mid -1;
            else left = mid+1;
        }
        
        if(right == -1)  return k;
        return arr[right]+k-compute(arr[right],right+1);  
        
    }
    
        int compute(int actual,int expected){
            return actual-expected;
            
        }
}