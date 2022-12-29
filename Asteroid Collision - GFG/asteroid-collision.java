//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // using stack 
        Stack<Integer> st = new Stack<Integer>();
        //pushig all the array values into the stack
        for(int i=0; i<N; i++)
        {
            st.push(asteroids[i]);
            
            
            while(st.size()>1)
            {
                int curr = st.pop();
                int prev = st.pop();
                
                if(curr<0 && prev>0)
                {
                    if(prev+curr == 0)
                    {
                        continue;
                    }
                    
                    int res = -curr > prev ? curr : prev;
                    st.push(res);
                }
                else
                {
                    st.push(prev);
                    st.push(curr);
                    break;
                }
            }
        }
        int len = st.size();
        int[] ans = new int[len];
        len--;
        while(st.isEmpty() == false)
        {
            ans[len--] = st.pop();
        }
        
        return ans;
    }
}

