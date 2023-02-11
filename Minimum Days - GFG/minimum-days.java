//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends

class Solution  {
    public static int getMinimumDays(int n, String s, int[] p) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) map.put(p[i], i+1);
        
        int i = 0, j =0;
        int days = 0;
        
        for(; j<n; j++) {
            if(s.charAt(i) != s.charAt(j)) {
                days = Math.max(days, code(s, i, j-1, map));
                i = j;
                j--;
            }}
        
        if(i != j-1) days = Math.max(days, code(s, i, j-1, map));
        return days;
    }
    
    private static int code(String s, int start, int end, Map<Integer, Integer> map)
    {
        int left = 0;
        for(int k=start; k<=end; k+=2) left = Math.max(left, map.get(k));
        
        int right = 0;
        for(int k=start+1; k<=end; k+=2) right = Math.max(right, map.get(k));
        
        return Math.min(left, right);
    }}