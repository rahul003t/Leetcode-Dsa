//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt(), A[] = new int[N];
    
            for (int i = 0; i < N; i++) A[i] = sc.nextInt();
    
            Solution ob = new Solution();
            out.println(ob.solve(N, A));
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int N, int[] A) {
        // code here
        
        //traversing  the array from the right side as the question given with decrementing
        for(int i=N-1; i>=0; i--)
        {
            //if arrayindex is less than 1  return the the value
            if(A[i] < 9)
            {
                //as given array is 1 base indexing rteunn index+1
                return i+1;
            }
        }
        //if all array contains >=9 return 0
        return 0;
    }
};