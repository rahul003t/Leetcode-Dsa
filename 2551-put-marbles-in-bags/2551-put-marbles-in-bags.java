class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        int [] arr=new int [n-1];
        for(int i=0; i<n-1; i++){
            arr[i]=weights[i]+weights[i+1];
        }

        Arrays.sort(arr);
        long minsum=0;
        long maxsum=0;
        for(int i=0; i<k-1; i++){
            minsum=minsum+arr[i];
        }

        for(int i=0; i<k-1; i++){
            maxsum=maxsum+arr[n-2-i];
        }

        return maxsum-minsum;
    }
}