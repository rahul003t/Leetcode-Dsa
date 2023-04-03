//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String x)
    {    
        // code here
        
        
        if(x.length()<=1)
        {
            return (x.charAt(0)-'0')%11;
        }
        int num1  =  x.charAt(0)-'0';
        int num2 = x.charAt(1)-'0';
        int ans  = ((num1 * 10) + num2) % 11;

        for(int i=2; i<x.length(); i++)
        {
            ans =  ((ans * 10) + (x.charAt(i)-'0')) %11;
             
        }

return ans;
    }
} 
