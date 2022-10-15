class Solution {
   public int getLengthOfOptimalCompression(String s, int K) {
        // dp[i][k]: the minimum length for s[:i] with at most k deletion.
        int n = s.length();
        int[][] dp = new int[n + 1][K + 1];
        for (int[] i : dp) Arrays.fill(i, n);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= K; k++) {
                if (k > 0) // delete s[i]
                    dp[i][k] = Math.min(dp[i][k], dp[i - 1][k - 1]);

                // keep s[i], concat the same, remove the different
                int same = 0, diff = 0;
                for (int j = i; j >= 1; j--) {
                    if (s.charAt(j - 1) == s.charAt(i - 1)) same++;
                    else diff++;
                    if (diff > k) break;
                    // baaaaaaccaaaa  k=2, s[i] = a, j will extend to index 1
                    dp[i][k] = Math.min(dp[i][k], dp[j - 1][k - diff] + getLen(same)); 
                }
            }
        }
        return dp[n][K];
    }

    private int getLen(int count) {
        if (count == 1) return 1;
        else if (count < 10) return 2;
        else if (count < 100) return 3;
        else return 4;
    }
}