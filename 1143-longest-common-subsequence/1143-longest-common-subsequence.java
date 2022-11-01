class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] arr = new int[text1.length()+1][text2.length()+1];
        
        for(int i=0;i<text1.length();i++)
        {
            for(int j=0;j<text2.length();j++)
            {
                if(text1.charAt(i) == text2.charAt(j))
                {
                    arr[i+1][j+1] = 1+arr[i][j];
                }
                else
                {
                    arr[i+1][j+1] = Math.max(arr[i][j+1],arr[i+1][j]);
                }
            }
        }
        
        return arr[text1.length()][text2.length()];
    }
}