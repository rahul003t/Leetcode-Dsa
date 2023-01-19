//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        int step=0;
        // creating l1 and b1 for the length and breadth of crapet
        int l1=Math.max(A,B);
        int b1=Math.min(A,B);
        
        //creating l,b for the length and breadth of the box
        int l= Math.max(C,D);
        int b= Math.min(C,D);
        
        while(l1>l || b1>b)
        {
            //when both the length and breadth of the carpet max then divide it by 2
            if(l1>l && b1>b)
            {
                l1/=2;
            }
            //when only the length of the carpet it greater
            else if(l1>l)
            {
                l1/=2;
            }
            else
            {
                b1/=2;
            }
            
            A=l1;
            B=b1;
            l1=Math.max(A,B);
            b1=Math.min(A,B);
            
            step++;
        }
        
        return step;
        
        
    }
   
}
