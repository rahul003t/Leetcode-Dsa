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
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {

    public static long bestNode(int N, int[] A, int[] P) {

        // code here

        HashSet<Integer> parentSet = new HashSet<>();

        for(int parent: P)parentSet.add(parent);

        ArrayList<Integer> leafNodes = new ArrayList<>();

        for(int i = 1; i <= P.length; i++){

          if(!parentSet.contains(i))leafNodes.add(i);

        }

        int maxiSum = Integer.MIN_VALUE;

        for(int leaf: leafNodes){

            int currentNode = leaf;

            int currentSum = 0;

            while(currentNode != -1){

                currentSum *= -1;

                currentSum += (A[currentNode-1]);

                maxiSum = Math.max(maxiSum, currentSum);

                currentNode = P[currentNode-1];

            }

 

        }

        return maxiSum;

    }

}

  
