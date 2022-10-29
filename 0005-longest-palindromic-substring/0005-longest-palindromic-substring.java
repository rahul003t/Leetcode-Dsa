class Solution {
    public String longestPalindrome(String s) {
        
        if(s.length() ==0 || s == null)
        {
            return s;
        }
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for(int i=1;i<len; i++)
        {
            dp[i][i] = true;
        }
        
        int maxLen=0,maxStart=0,maxEnd=0;
        for(int i=len;i>=0;i--)
        {
            for(int dist=1;dist<len-i;dist++)
            {
                int j = i+dist;
                
                if(dist ==1 && s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]=true;
                }
                else if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j] = dp[i+1][j-1];
                }
                
                if(dp[i][j] && maxLen  < (j-i+1))
                {
                    maxLen = j-i+1;
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        
        return s.substring(maxStart, maxEnd+1);
    }
}