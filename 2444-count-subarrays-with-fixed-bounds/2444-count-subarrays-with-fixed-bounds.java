class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex=-1,maxIndex=-1,start=0,n=nums.length;
        long res=0;

        for(int i=0;i<n;i++){
            int val=nums[i];
            if(val>maxK || val<minK){
                 start=i+1;
                 minIndex=-1;
                 maxIndex=-1;
            }
            if(val==minK) minIndex=i;
            if(val==maxK) maxIndex=i;
            res+=Math.max(0,Math.min(minIndex,maxIndex)-start+1);
        }

        return res;
    }
}