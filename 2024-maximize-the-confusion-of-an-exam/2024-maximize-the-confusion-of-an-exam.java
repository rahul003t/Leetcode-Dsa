class Solution {
    boolean check(int len , int[] trueLen, int k){
        int n = trueLen.length;
        int i=-1;
        for(int j=len-1;j<n;j++){
            int noOfTrue =  trueLen[j];
            if(j!=len-1){
                noOfTrue = noOfTrue - trueLen[i];
            }
            int noOfFalse = len - noOfTrue;
            if(noOfTrue<=k || noOfFalse<=k) return true;
            i++;
        } 
        return false;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int low = 1;
        int high = answerKey.length();
        int ans=0;

        System.out.println(high);

        int[] trueLen = new int[high];
        for(int i=0;i<high;i++){
            char ch = answerKey.charAt(i);
            if(ch=='T'){
                trueLen[i] = i==0 ? 1 : trueLen[i-1]+1;  
            }else trueLen[i] = i==0 ? 0 : trueLen[i-1];
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            boolean flag = check(mid, trueLen , k);
            if(flag){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}