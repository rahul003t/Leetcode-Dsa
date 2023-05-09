//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            long N = Long.parseLong(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.countStrings(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    final int MOD = 1000000007;
    long[][] multiply(long[][] a, long[][] b) {
        long[][] matrix = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long count = 0;
                for (int k = 0; k < 2; k++) {
                    count = (count % MOD + (a[i][k] * b[k][j]) % MOD) % MOD;
                }
                matrix[i][j] = count % MOD;
            }
        }
        return matrix;
    }

    long[][] matrixExponentiation(long[][] v, long n) {
        if (n == 1) {
            return v;
        }
        long[][] temp = matrixExponentiation(v, n / 2);
        long[][] ans = multiply(temp, temp);
        if (n % 2 == 1) {
            ans = multiply(ans, v);
        }
        return ans;
    }
    public int countStrings(long N) {
        // Code here
           long[][] matrix = new long[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 0;
        matrix = matrixExponentiation(matrix, N);
        return (int) ((matrix[0][0] + matrix[0][1]) % MOD);
    }
}

