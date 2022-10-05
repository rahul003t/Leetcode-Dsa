class Solution {
    public int subtractProductAndSum(int n) {
        
        int totalSum=0, product=1;
        
        while(n>0)
        {
            int rem = n%10;
            
            totalSum += rem;
            
            product *=rem;
            
            
            n /= 10;
        }
        
        return product-totalSum;
    }
}