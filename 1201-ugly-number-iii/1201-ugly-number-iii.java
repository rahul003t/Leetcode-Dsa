class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
    
        int lo=0;
        int hi=Integer.MAX_VALUE;
        
        long ab=lcm(a,b),bc=lcm(b,c),ac=lcm(a,c),abc=lcm(ab,c);
        
        while(lo < hi)
        {
            int mid = lo+(hi-lo)/2;
            
            long count =0L+ mid/a+mid/b+mid/c-mid/ab-mid/ac-mid/bc+mid/abc;
            
            if(count >=n){
                hi = mid;
            }
            else{
                lo=mid+1;
            }
        }
        
        return lo;
        
        
        
    }
    long gcd(long a ,long b){
        return b==0 ? a : gcd(b,a%b);
    }
    
    long lcm(long a ,long b){
        return a*b /gcd(a,b);
    }
}