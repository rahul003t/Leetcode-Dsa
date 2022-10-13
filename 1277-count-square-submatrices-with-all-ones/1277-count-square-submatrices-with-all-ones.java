class Solution {
    public int countSquares(int[][] matrix) {
        
        int arr[][] = new int[matrix.length+1][matrix[0].length+1];
        int sum=0;
        
        for(int i=1;i<=matrix.length;i++)
        {
            for(int j=1;j<=matrix[0].length;j++)
            {
                if(matrix[i-1][j-1] != 0)
                {
                    sum += (arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i][j-1]),arr[i-1][j-1])+1); 
                }
            }
        }
        
        return sum;
        
    }
}