class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long l = 0,r = maxSum;

        while(l<=r){
            long mid = (l+r)/2;
            if(getTotalSum(mid,n,index) <= (long)maxSum){
                if(getTotalSum(mid+1,n,index) > (long)maxSum){
                    return (int)mid;
                }else{
                    l = mid + 1;
                }
            }else{
                r = mid - 1;
            }
        }

        return 1;
    }

    long getTotalSum(long m,int n,int index){
        long sum = m;
        if(n-index-1 > 0){
            long len = n-index-1;
            if((m-1-len) > 0 )
                sum += ((m-1)*m/2 - (m-1-len)*(m-len)/2);
            else
                sum += (m-1)*m/2 + (len-(m-1));        
        }

        if(index > 0){
            long len = index;
            if((m-1-len) > 0 )
                sum += ((m-1)*m/2 - (m-1-len)*(m-len)/2);
            else
                sum += (m-1)*m/2 + (len-(m-1));
                
        }
        
        return sum;
    }
}