class Solution {
    public int minCost(int m, int[] cuts) {
        int n = cuts.length + 2;
        Arrays.sort(cuts);
        int arr[] = new int[n];
        arr[0] = 0;
        arr[n - 1] = m;
        for (int i = 1; i < n - 1; i++) arr[i] = cuts[i - 1];

        int dp[][] = new int[n][n];

        for (int i = 2; i < n; i++) {
            for (int left = 0; left < n && i + left < n; left++) {
                int right = i + left;
                int min = Integer.MAX_VALUE;
                for (int k = left + 1; k < right; k++) {
                    min = Math.min(min, dp[left][k] + dp[k][right]);
                }

                dp[left][right] = min + arr[right] - arr[left];
            }
        }
        return dp[0][n - 1];
    }
}