class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int n = arr.length;
        int sum=0;
        for(int x: arr){
            sum+=x;
        }
        
        
        if(n < 3){
            return sum;
        }
        
        int len =3;
        while(len <= n){
            
            int currSum=0;
            for(int i=0;i<len;i++){
                currSum+=arr[i];
            }
            sum+=currSum;
            
            for(int i=len;i<n;i++){
                currSum = currSum+arr[i]-arr[i-len];
                sum+=currSum;
            }
            len+=2;
        }
        return sum;
    }
}