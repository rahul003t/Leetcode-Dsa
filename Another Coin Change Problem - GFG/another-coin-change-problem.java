//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    // for memoization
    private static int[][][] dp;

    private static boolean solve(int idx, int k, int target, int[] coins) {
        if (k == 0 && target == 0)
            return true;

        if (idx == coins.length || k == 0)
            return false;

        if (dp[idx][k][target] != -1)
            return dp[idx][k][target] == 1;

        // we can take coin of lets say 3, any number of times
        // (that's why using a loop)
        // but all total no. of coins must be k
        // like if k = 5, then coins can be: 3*4 + 5*1
        // (total no of coins = 4 + 1 = 5)

        // alternate approach to loop:
        // dp[n][k][target] = solve(idx,k-1, target - coins[n-1], coins, dp)
        // || solve(idx + 1, k, target, coins, dp);
        // (i.e., call with same idx(to simulate loop))
        // or call without this element
        for (int i = 1;; i++) {
            if (k - i < 0 || (coins[idx] * i > target))
                break;
            if (solve(idx + 1, k - i, target - (coins[idx] * i), coins)) {
                dp[idx][k][target] = 1;
                return true;
            }
        }

        dp[idx][k][target] = solve(idx + 1, k, target, coins) ? 1 : 0;
        return dp[idx][k][target] == 1;
    }

    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        dp = new int[N][K + 1][target + 1];
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        return solve(0, K, target, coins);
    }
}