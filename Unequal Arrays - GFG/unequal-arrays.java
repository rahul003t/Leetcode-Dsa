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
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        int sumA = 0, sumB = 0;
       List<Integer> oddA = new ArrayList<>();
       List<Integer> oddB = new ArrayList<>();
       List<Integer> evenA = new ArrayList<>();
       List<Integer> evenB = new ArrayList<>();
       
       for(int i = 0 ; i < N; i++){
           sumA += A[i];
           sumB += B[i];
           if(A[i] % 2 != 0){
               oddA.add(A[i]);
           }else{
               evenA.add(A[i]);
           }
           
            if(B[i] % 2 != 0){
               oddB.add(B[i]);
           }else{
               evenB.add(B[i]);
           }
       }
       if(sumA != sumB)
       return -1;
       if(oddA.size() != oddB.size() || evenA.size() != evenB.size())
       return -1;
       
       Collections.sort(oddA);
       Collections.sort(oddB);
       Collections.sort(evenA);
       Collections.sort(evenB);
       
       long total = 0;
       for(int i = 0 ; i < oddA.size(); i++){
           total += (Math.abs(oddA.get(i) - oddB.get(i)))/2;
       }
       for(int i = 0 ; i < evenA.size(); i++){
           total += (Math.abs(evenA.get(i) - evenB.get(i)))/2;
       }  
       return total/2;
    }
}