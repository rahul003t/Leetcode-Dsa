class Solution {
    public int smallestEvenMultiple(int n) {
        
        if((n & 1) ==0){
            return n;
            
        }
        
        return 2*n;
    }
}