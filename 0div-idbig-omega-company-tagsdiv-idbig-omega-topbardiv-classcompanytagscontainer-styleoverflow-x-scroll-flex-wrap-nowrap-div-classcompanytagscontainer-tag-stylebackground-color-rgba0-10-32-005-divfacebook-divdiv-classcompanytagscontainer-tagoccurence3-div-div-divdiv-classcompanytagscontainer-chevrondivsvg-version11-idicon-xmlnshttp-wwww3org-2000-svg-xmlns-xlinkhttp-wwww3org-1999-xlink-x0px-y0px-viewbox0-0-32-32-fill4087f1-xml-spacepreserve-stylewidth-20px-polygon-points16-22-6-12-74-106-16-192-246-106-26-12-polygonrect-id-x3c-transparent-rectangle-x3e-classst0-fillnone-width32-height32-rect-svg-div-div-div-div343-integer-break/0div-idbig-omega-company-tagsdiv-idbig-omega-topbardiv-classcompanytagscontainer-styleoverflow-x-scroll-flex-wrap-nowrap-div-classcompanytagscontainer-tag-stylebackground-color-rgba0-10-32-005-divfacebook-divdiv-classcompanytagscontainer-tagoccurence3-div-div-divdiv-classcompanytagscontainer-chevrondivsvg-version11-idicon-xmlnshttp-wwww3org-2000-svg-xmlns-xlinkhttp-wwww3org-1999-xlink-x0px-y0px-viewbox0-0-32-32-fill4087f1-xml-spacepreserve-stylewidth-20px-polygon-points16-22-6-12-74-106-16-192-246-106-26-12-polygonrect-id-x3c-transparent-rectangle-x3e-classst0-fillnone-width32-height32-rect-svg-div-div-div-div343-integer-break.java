class Solution {
    public int integerBreak(int n) {
        
        if(n==2)
        {
            return 1;
        }
        if(n==3)
        {
            return 2;
        }
        
        int noOf_3s=n/3;
        int reminder=n%3;
        
        if(reminder ==0)
        {
            return (int) Math.pow(3,noOf_3s);
        }
        else if(reminder==1)
        {
            return (int) Math.pow(3,(noOf_3s-1))*4;
        }
        else
        {
            return (int) Math.pow(3,noOf_3s)*2;
        }
        
    }
}