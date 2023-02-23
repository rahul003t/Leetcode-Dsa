//{ Driver Code Starts
import java.util.*;
import java.lang.Math;

class Sorting
{
	
	static void printArray(int arr[],int size)
	{
		int i;
		for(i=0;i<size;i++)
		System.out.print(arr[i]+" ");
	    System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
		
			for(int i=0;i<n;i++)
			a[i]= sc.nextInt();
			
			 new Solution().insertionSort(a,n);
			 printArray(a,n);
			
		t--;
		}
		
	}
}
// } Driver Code Ends


class Solution
{
  static void insert(int arr[],int i)
  {
       // Your code here
       while(i > 0 && arr[i - 1] > arr[i]){

           int temp = arr[i -1];

           arr[i - 1] = arr[i];

           arr[i] = temp;

           i--;
  }
  
  }
  //Function to sort the array using insertion sort algorithm.
   static void insertionSort(int arr[], int n)
  {
     //code here
     
          for(int j=0; j<n; j++){

          int i = j;

          insert(arr , j);
  }
}

}