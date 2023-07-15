class Solution {
  public int maxValue(int[][] events, int k) {
    Integer[][] dp = new Integer[events.length][k + 1];
    Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    return maxValue(events, 0, k, dp);
  }
  private int maxValue(int[][] events, int i, int k, Integer[][] dp) {
    if (k == 0 || i == events.length)
      return 0;
    if (dp[i][k] != null)
      return dp[i][k];
    final int j = binarySearch(events, i + 1, events[i][1] + 1);
    return dp[i][k] = Math.max(events[i][2] + maxValue(events, j, k - 1, dp), maxValue(events, i + 1, k, dp));
  }
  private int binarySearch(int[][] events, int l, int target) {
    int r = events.length;
    while (l < r) {
      final int m = (l + r) / 2;
      if (events[m][0] >= target)
        r = m;
      else
        l = m + 1;
    }
    return l;
  }
}