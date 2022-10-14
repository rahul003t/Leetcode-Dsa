class Solution {
    public int climbStairs(int n) {
        
        int[] arr = new int[n+1];
        
        if(n <= 1)
        {
            return n;
        }
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        
        for(int i=3;i<=n;i++)
        {
            arr[i] = arr[i-1]+arr[i-2];
        }
   
        
        return arr[n];
        
        
    }
        
}