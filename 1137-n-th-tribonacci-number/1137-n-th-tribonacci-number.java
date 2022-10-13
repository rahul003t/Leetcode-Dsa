class Solution {
    public int tribonacci(int n) {
//         if( n==0|| n==1 ||n==2) return n;
//        // if(n==3) return 2;
        
//         return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        
        if(n==0)
        return 0;
    int t0=0,t1=1,t2=1;
    
    for(int i=3;i<=n;i++){
        int temp=t2;
        t2=t2+t1+t0;
        t0=t1;
        t1=temp;
    }
    return t2;
        
    }
}