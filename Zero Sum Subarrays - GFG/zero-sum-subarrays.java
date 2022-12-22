//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //long count = 0;
        //HashMap<Integer,Integer> map = new HashMap<>();
        
        //return type is long
        HashMap <Long , Long> map =  new HashMap<>();
        
        long sum=0,count=0;
        //itterate the array and find subarray of sum zero
        for(long i : arr)
        {
            sum += i;
            
            // if map contains the key value then add 
            if(map.containsKey(sum))
            {
                count += map.get(sum);
            }
            // while itterating if sum=0 then add 1 to the count value  
            if(sum ==0)
            {
                count++;
            }
            
            map.put(sum,map.getOrDefault(sum,0l) + 1l);
        }
        
        return count;
    }
}