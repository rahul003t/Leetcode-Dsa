//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        // code here
        Arrays.sort(arr, (a,b)->a.length()==b.length() ?a.compareTo(b) :a.length()-b.length());
        HashSet<String> hs = new HashSet<>();
        hs.add(arr[0]);
        
        String s = "";
        if(arr[0].length()>1)
            return s;
            
        s=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i].length()==1)
                hs.add(arr[i]);
            
            if(hs.contains(arr[i].substring(0, arr[i].length()-1))){
                hs.add(arr[i]);
                if(arr[i].length()>s.length()) 
                    s=arr[i];    
            }    
            
        }
        return s;
    }
}