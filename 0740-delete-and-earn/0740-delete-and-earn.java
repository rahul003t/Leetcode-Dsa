class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] arr = new int[10001];
        for(int i : nums)
        {
            arr[i] += i;
        }
        
        int[] dp = new int[10003];
        for(int i=10000;i>=0;i--)
        {
            dp[i] = Math.max(arr[i]+dp[i+2], dp[i+1]);
        }
        
        return dp[0];
    }
}