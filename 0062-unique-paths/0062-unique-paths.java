// class Solution {
//     public int uniquePaths(int m, int n) {
        
//         if(m == 1 || n == 1)                                     //TLE OCCURS
//             return 1;
//         return uniquePaths(m-1, n) + uniquePaths(m, n-1);
        
         
//     }
// }



class Solution {
    public int uniquePaths(int m, int n) {
        
        //dp matrix
        
        int[][] t = new int[m][n];
        
        
        //Initialization 
        
        for(int i=0;i<m;i++){
            t[i][0]=1;
        }
        for(int j=1;j<n;j++){
            t[0][j]=1;
        }
        
        
        //from all the places robot have two ways, so, current total paths=sum of last two possible paths.
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                t[i][j]=t[i-1][j]+t[i][j-1];
            }
        }
        return t[m-1][n-1];
    }
}