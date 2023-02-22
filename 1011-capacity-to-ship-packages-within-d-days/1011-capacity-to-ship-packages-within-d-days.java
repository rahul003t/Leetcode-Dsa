class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int val: weights){
          sum+=val;
          max = Math.max(max,val);
        }
        if(weights.length==days){
            return max;
        }
        int lo = max;
        int hi = sum;
        int ans = 0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(weights,mid,days)==true){ // Maxmium value of mids in days we can ship all packages
            ans=mid;
            hi=mid-1; // to take more days
        }
        else{
    lo=mid+1;
        }
    }
    return ans;
}
public static boolean isPossible(int []weights,int mid,int days)
{
    int d =1;
    int sum = 0;

    for(int i = 0;i<weights.length;i++){
        sum+=weights[i];

        if(sum>mid){
            d++;
            sum=weights[i];
        }
    }
    return d<=days;
}
}