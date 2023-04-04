class Solution {
    public int partitionString(String s) {
        int i=0,j=0,max=1,n=s.length(),cnt=1;
        HashMap h=new HashMap();
        while(j<n)
        {
            int x=(int) h.getOrDefault(s.charAt(j),0);
            h.put(s.charAt(j),x+1);
            
            if(h.size()!=(j-i+1))
            {
               //System.out.println(h);
                h.clear();
                h.put(s.charAt(j),1);
                i=j;
                cnt ++;
            }
              j++;
        }
        return cnt;
    }
}