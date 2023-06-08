//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
   public static String kthPermutation(int n,int k) {
        // code here
       ArrayList<Integer>deban=new ArrayList<>();
        ArrayList<Integer>app=new ArrayList<>();
        int pro=1;
        String ans="";
        for(int i=0;i<n;i++)
        {
            app.add(i+1);
        }
        for(int l=n;l>=1;l--)
        {
           
        for(int i=1;i<=l;i++)
        {
            pro=pro*i;
        }
        int d=pro/l;
        for(int i=0;i<app.size();i++)
        {
            deban.add((i+1)*d);
           
        }
        for(int i=0;i<app.size();i++)
        {
            if(deban.get(i)<k)
            {
                continue;
            }
           else
            {
                ans+=app.get(i);
                 k=k-deban.get(i)+d;
                app.remove(i);
                break;
               
            }
        }
        deban.clear();
        pro=1;
        }
        return ans;
    }
}
        


//{ Driver Code Starts.

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
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends