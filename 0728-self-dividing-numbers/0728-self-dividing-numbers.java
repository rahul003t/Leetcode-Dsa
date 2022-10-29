class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> res = new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            if(isDivide(i))
            {
                res.add(i);
            }
        }
        
        return res;
    }
    
    boolean isDivide(int num)
    {
        int n=num;
        while(n >0)
        {
            int rem = n%10;
            if(rem==0 || (num%rem)!=0  )
            {
                return false;
            }
            n /= 10;
        }
        
      return true;
    }
   
}