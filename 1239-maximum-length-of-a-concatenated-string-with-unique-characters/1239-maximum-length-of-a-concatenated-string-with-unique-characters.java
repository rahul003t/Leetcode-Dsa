class Solution {
    private boolean checkUnique(String x)
    {
        int[] fq=new int[26];
        
        for(char c:x.toCharArray())
        {
            if(++fq[c-'a']>1)
                return false;
        }
        return true;
    }
    
    public int maxLength(List<String> arr) 
    {
        List<String> list=new ArrayList<>();
        int ans=0;
        for(String str:arr)
        {
            List<String> tmp=new ArrayList<>();
            if(!checkUnique(str))
                continue;
            tmp.add(str); // store all combination of strings formed
            ans=Math.max(ans,str.length());
            for(String s:list)
            {
                String cur=s+str;  // combination
                if(checkUnique(cur))
                {
                    tmp.add(cur);
                    ans=Math.max(ans,cur.length());
                }
            }
            list.addAll(tmp);  // Main list  
        }
        return ans;
    }
}