class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr[1]-arr[0];
        int i=2;
        
        while( i<arr.length)
        {
            int x = arr[i]-arr[i-1];
            
            if(x == n)
            {
                i++;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}