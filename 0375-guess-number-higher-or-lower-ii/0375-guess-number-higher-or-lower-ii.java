class Solution {
    public int getMoneyAmount(int n) {
        
        int[][] table = new int[n+1][n+1];
        return dp(table,1,n);
    }
    
    int dp(int[][] t,int r, int c)
    {
        if(r >= c)
        {
            return 0;
        }
        if(t[r][c] != 0)
        {
            return t[r][c];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=r; i<=c; i++)
        {
            int temp = i+Math.max(dp(t,r,i-1),dp(t,i+1,c));
            ans = Math.min(ans,temp);
        }
        t[r][c] = ans;
        return ans;
    }
}