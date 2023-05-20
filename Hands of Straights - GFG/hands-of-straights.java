//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        if (groupSize == 1) {
            return true;
        }
        
        if (((N & 1) ^ (groupSize & 1)) == 1) {
            return false;
        }
        
        Map<Integer, Integer> tmap = new TreeMap<>();
        
        for (int h: hand) {
            tmap.put(h, tmap.getOrDefault(h, 0) + 1);
        }
        
        for (int key: tmap.keySet()) {
            while (tmap.get(key) > 0) {
                for (int i = 0 ; i < groupSize ; i++) {
                    if (!tmap.containsKey(key+i) || tmap.getOrDefault(key+i, 0) == 0) {
                        return false;
                    }
                }
                
                for (int i = 0 ; i < groupSize ; i++) {
                    tmap.put(key+i, tmap.get(key+i) - 1);
                }
            }
        }
        
        return true;
    }
}