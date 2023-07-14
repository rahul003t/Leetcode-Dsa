class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        int[] dp = new int[max - min + 1];
        max = 1;

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i] - min, pred = cur - difference;
            if (pred >= 0 && pred < dp.length) {
                dp[cur] = 1 + dp[pred];
                if (dp[cur] > max) max = dp[cur];
            } else {
                dp[cur] = 1;
            }
        }
        return max;
    }
}