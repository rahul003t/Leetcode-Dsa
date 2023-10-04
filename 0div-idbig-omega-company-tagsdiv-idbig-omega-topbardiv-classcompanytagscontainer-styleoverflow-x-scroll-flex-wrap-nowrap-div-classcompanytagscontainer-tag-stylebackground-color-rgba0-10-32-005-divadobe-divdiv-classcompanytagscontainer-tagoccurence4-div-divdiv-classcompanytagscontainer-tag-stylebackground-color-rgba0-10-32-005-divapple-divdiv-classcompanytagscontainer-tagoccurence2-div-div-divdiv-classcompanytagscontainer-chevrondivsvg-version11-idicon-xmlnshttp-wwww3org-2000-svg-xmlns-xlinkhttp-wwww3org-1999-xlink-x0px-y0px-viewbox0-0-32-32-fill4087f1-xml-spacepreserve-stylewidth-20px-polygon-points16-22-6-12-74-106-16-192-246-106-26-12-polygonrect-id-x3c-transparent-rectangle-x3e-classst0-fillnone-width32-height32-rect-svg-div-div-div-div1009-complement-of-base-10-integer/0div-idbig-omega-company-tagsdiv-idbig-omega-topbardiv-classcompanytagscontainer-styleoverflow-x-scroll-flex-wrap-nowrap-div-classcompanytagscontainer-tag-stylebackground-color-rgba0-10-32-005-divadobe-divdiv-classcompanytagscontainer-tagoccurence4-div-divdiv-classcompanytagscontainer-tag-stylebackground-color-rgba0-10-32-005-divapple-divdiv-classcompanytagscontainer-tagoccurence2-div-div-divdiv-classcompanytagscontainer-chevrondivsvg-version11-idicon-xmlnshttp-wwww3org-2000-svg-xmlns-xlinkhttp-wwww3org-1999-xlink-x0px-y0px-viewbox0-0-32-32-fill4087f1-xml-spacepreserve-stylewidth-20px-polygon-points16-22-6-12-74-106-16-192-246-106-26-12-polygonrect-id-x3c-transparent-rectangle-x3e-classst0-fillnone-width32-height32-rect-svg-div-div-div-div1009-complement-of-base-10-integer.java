class Solution {
    public int bitwiseComplement(int n) {
        
        if( n ==0)
        {
             return 1;
        }
        int rem,mul=1,ans=0;
        
        while(n != 0)
        {
            rem = n%2;
            rem = rem^1;
            
            n /= 2;
            ans = ans +rem*mul;
            mul *= 2;
            
        }
        return ans;
    }
}