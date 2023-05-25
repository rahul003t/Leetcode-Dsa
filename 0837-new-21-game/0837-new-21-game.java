class Solution {
    public double new21Game(int n, int k, int W) {
        
        if(k==0 || n>=k+W)
            return 1;
        double dp[] = new double[n+1], Wsum=1, res=0;
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            dp[i] = Wsum/W;
            if(i<k)
                Wsum += dp[i];
            else
                res += dp[i];
            
            if(i-W>=0)
                Wsum -= dp[i-W];
        }
        return res;
    }
}