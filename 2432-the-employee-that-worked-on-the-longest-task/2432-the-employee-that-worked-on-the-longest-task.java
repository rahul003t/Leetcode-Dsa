class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int len = logs[0][1], id = logs[0][0];
        
        for(int i=1; i<logs.length;i++)
        {
            int curr = logs[i][1] - logs[i-1][1]; 
            if(curr > len || curr==len && id > logs[i][0])
            {
                len = curr;
                id = logs[i][0];
                
            }
        }
        
        return id;
    }
}