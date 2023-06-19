class Solution {
    public int largestAltitude(int[] gain) {
        int min =0;
        int[] arr = new int[gain.length+1];
        arr[0] =0;
        
        for(int i=1;i<arr.length;i++)
        {
            arr[i] = arr[i-1]+gain[i-1];
            
            if(arr[i] > min)
            {
                min = arr[i];
            }
        }
        
        return min;
        
    }
}