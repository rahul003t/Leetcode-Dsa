class Solution {
    public int integerBreak(int n) {
        int[] arr = new int[n+1];
        arr[1]=1;
        
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<i;j++)
            {
                arr[i] = Math.max(arr[i],(Math.max(j,arr[j])) * (Math.max(i-j,arr[i-j])));
            }
        }
        
        return arr[n];
    }
}