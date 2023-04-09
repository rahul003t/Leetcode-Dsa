//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int A;
            A = Integer.parseInt(br.readLine());
            
            
            int B;
            B = Integer.parseInt(br.readLine());
            
            
            int C;
            C = Integer.parseInt(br.readLine());
            
            
            int D;
            D = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.bestNumbers(N, A, B, C, D);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    private static final int MAX_SIZE = 100005; // maximum size of arrays
private static final int MOD = 1000000007; // a large prime number used for modulo operations
private static long[] factorial = new long[MAX_SIZE]; // array to store factorials
private static long[] inverseFactorial = new long[MAX_SIZE]; // array to store inverse factorials

public static int bestNumbers(int N, int A, int B, int C, int D) {
    // initialize factorials and inverse factorials if not done already
    computeFactorials();
    long answer = 0;
    if (A == B) { // if A and B are equal, there is only one possible sum
        int sum = N * A;//one possible sum of good number
        while (sum > 0) {
            if (sum % 10 == C || sum % 10 == D) { // check if sum contains C or D
                return 1; // if it does, return 1
            }
            sum /= 10; // remove last digit from sum
        }
        return 0; // if no best number is found, return 0
    }
    for (int i = 0; i <= N; i++) { // loop through all possible values of i
        int sum = i * A + (N - i) * B; // calculate sum of digits of good number
        boolean isBest = false;
        while (sum > 0) {
            if (sum % 10 == C || sum % 10 == D) { // check if sum contains C or D
                isBest = true; // if it does, mark isBest as true
                break;
            }
            sum /= 10; // remove last digit from sum
        }
        if (isBest) { // if sum is a best number, add the corresponding nCr value to answer
            answer += calculateNcr(N, i);
            answer %= MOD; // take modulo to avoid overflow
        }
    }
    return (int) answer; // return final answer
}

private static void computeFactorials() { // function to precompute factorials and inverse factorials
    factorial[0] = 1;
    for (int i = 1; i < MAX_SIZE; i++) { // calculate factorials for all values up to MAX_SIZE-1
        factorial[i] = (i * factorial[i - 1]) % MOD; // use modulo to avoid overflow
    }
    inverseFactorial[MAX_SIZE - 1] = calculatePower(factorial[MAX_SIZE - 1], MOD - 2, MOD); // calculate inverse factorial for MAX_SIZE-1
    for (int i = MAX_SIZE - 2; i >= 0; i--) { // calculate inverse factorials for all values from MAX_SIZE-2 down to 0
        inverseFactorial[i] = ((i + 1) * inverseFactorial[i + 1]) % MOD; // use modulo to avoid overflow
    }
}



private static long calculatePower(long base, long exponent, long mod) {
        long result = 1;
        base %= mod; // take modulo of base with mod
        while (exponent > 0) {
            if (exponent % 2 == 1) { // if exponent is odd
                result = (result * base) % mod; // multiply result with base and take modulo with mod
            }
            exponent >>= 1; // right shift exponent
            base = (base * base) % mod; // square base and take modulo with mod
        }
        return result; // return the result
    }
    
private static long calculateNcr(int n, int r) {
    long answer = (((factorial[n] * inverseFactorial[n - r]) % MOD) * inverseFactorial[r]) % MOD;
    return answer; // return the result of n choose r modulo MOD
    }
}
        
