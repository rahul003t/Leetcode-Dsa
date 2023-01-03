//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N)
    {
        // 
        int LTS = lengthofLTS(H);
        return N-LTS;
        
    }
    
    public static int lengthofLTS(int[] H)
    {
        int[] a = new int[H.length+1];
        Arrays.fill(a,Integer.MAX_VALUE);
        a[0]=Integer.MIN_VALUE;
        
        for(int h: H)
        {
          int idx = BS(a,h);
          a[idx+1] = h;
        }
        
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i] != Integer.MAX_VALUE)
            {
                return i;
            }
        }
        return 0;
    }
        
        
         // Binary search for the sorted part
        public static int BS(int[] a,int m)
        {
            int start=0,end=a.length-1,max=0;
            while(start <= end)
            {
                int mid = start +(end - start)/2;
                if(a[mid] < m)
                {
                    start = mid+1;
                    max = Math.max(max,mid);
                }
                else
                {
                    end = mid-1;
                }
            }
            return max;
        }
};