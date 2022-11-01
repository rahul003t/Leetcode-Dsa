class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        
        for(int i=1;i<dp.length;i++)
        {
            dp[i]=dp.length;
            for(int j=0;j<coins.length;j++)
            {
                if( i >= coins[j])
                {
                    dp[i] = Math.min(dp[i] ,dp[i-coins[j]]+1);
                }
            }
            
        }
        
        return dp[amount] == dp.length ? -1:dp[amount];
    }
    
}