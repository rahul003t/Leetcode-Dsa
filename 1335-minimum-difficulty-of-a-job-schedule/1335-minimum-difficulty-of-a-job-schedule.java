class Solution {
    static int inf = Integer.MAX_VALUE;
    public static int function(int[] jobDifficulty, int n, int i, int d, int[][] dp) {
        if(d == 0 && i == n) return 0;
        if(d == 0 || i == n) return inf;
        if(dp[i][d] != -1) return dp[i][d];
        int currMax = jobDifficulty[i];
        int min = inf;
        for(int j = i; j < n; j++) {
            currMax = Math.max(jobDifficulty[j], currMax);
            int temp = function(jobDifficulty, n, j + 1, d - 1, dp);
            if(temp != inf) min = Math.min(min, temp + currMax);
        }
        return dp[i][d] = min;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n) return -1;
        int[][] dp = new int[n][d + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < d + 1; j++) dp[i][j] = -1;
        }
        return function(jobDifficulty, n, 0, d, dp);
    }
}