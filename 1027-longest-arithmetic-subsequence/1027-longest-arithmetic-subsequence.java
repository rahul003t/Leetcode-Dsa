class Solution {
       public static int longestArithSeqLength(int[] nums) 
    {
        int n = nums.length, ans = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        if(nums[i] > max)
        max = nums[i];

        int dp[][] = new int[n][max*2+1];
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                int diff = nums[i]-nums[j];
                int idx = diff + max;
                int prevLen = dp[j][idx];
                if(prevLen == 0)
                {
                    dp[j][idx] = 1;
                    prevLen = 1;
                }
                dp[i][idx] = prevLen + 1;
                ans = Math.max(ans, prevLen+1);
            }
        }
        return ans;
    }
}