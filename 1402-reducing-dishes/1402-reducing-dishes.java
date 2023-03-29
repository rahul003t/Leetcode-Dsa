class Solution {
    public int maxSatisfaction(int[] satisfaction) {
// sort the given array
        Arrays.sort(satisfaction);
        int sum=0,ans=0;
// run back loop add the all value of given array if value is negative then break the loop and add value in new value 
        for(int i=satisfaction.length-1;i>=0;i--){
                sum+=satisfaction[i];
                if(sum<0){
                    break;
                }
                ans+=sum;
        }
        return ans;
    }
}