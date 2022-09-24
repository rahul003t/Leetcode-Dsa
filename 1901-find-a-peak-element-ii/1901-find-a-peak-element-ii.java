class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int m=mat.length;
        int n = mat[0].length;
        int[] res = new int[2];
        int max =-1;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(max < mat[i][j]){
                    max = mat[i][j];
                    
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
}