class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        int n = plantTime.length;
        int[][] arr = new int[n][2];
        
        for(int i=0;i<n;i++)
        {
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }
        
        Arrays.sort(arr,(a,b)->b[1] - a[1]);
        
        int bloomyDay=0, seedPlantingDay=0;
        for(int i=0;i<n;i++)
        {
            int ptime= arr[i][0];
            int gtime=arr[i][1];
            
            bloomyDay = Math.max(bloomyDay, seedPlantingDay+ptime+gtime);
            seedPlantingDay = seedPlantingDay+ptime;
        }
        
        return bloomyDay;
    }
}