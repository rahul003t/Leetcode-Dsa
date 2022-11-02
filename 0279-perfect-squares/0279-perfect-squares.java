class Solution {
    public int numSquares(int n) {
        
        int ans[] = new int[n+1];
        ans[0]=0;
        ans[1]=1;
        
        for(int i=2;i<=n;i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=1; j * j <= i; j++)
            {
                int rem =i-j*j;
                if(ans[rem] < min)
                {
                    min=ans[rem];
                }
                
            }
            ans[i]=min+1;
        }
        
        return ans[n];
            
    }
}