class Solution {
public:
    int mySqrt(int x) {
        if(x<2)
        {
            return x;
        }
        int start=0,mid,end=x,ans;
        while(start <= end)
        {
            mid = start +(end-start)/2;
            if(mid ==x/mid)
            {
                ans = mid;
                break;
            }
            else if(mid < x/mid)
            {
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
};