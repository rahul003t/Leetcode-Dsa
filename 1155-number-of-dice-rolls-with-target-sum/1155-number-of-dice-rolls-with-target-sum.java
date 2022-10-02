class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (target > 900) {
            return 0;
        }
        
        int mod = (int) 1e9 + 7;
        int[][] arr = new int[n + 1][901];
        
        for (int i = 1; i <= Math.min(target, k); i++) { // n == 1 roll 1 time
            arr[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i ++) {
            for (int val = 1; val <= target; val++) {
                for (int face = 1; face <= k; face++) {
                    if (val <= face) {
                        break;
                    }
                   arr[i][val] = (arr[i][val] + arr[i - 1][val - face]) % mod;
                }
            }
        }
        return arr[n][target];
    }
}