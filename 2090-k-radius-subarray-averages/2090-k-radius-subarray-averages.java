class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int m = 2 * k + 1;
        
        long sum = 0;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);

        if (n < m) return ans;

        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (i - m >= 0)sum -= nums[i - m];
            if (i >= m - 1) ans[i - k] = (int) (sum / m);
        }

        return ans;
    }
}
