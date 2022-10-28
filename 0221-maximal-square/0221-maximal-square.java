class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        if(matrix.length==0)
        {
            return 0;
        }
        int ans =0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr=new int[m+1][n+1];
        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    arr[i][j] = Math.min(Math.min(arr[i][j-1],arr[i-1][j-1]),arr[i-1][j])+1;
                    ans = Math.max(ans,arr[i][j]);
                }
            }
            
        }
        return ans*ans;
        
        
    }
}