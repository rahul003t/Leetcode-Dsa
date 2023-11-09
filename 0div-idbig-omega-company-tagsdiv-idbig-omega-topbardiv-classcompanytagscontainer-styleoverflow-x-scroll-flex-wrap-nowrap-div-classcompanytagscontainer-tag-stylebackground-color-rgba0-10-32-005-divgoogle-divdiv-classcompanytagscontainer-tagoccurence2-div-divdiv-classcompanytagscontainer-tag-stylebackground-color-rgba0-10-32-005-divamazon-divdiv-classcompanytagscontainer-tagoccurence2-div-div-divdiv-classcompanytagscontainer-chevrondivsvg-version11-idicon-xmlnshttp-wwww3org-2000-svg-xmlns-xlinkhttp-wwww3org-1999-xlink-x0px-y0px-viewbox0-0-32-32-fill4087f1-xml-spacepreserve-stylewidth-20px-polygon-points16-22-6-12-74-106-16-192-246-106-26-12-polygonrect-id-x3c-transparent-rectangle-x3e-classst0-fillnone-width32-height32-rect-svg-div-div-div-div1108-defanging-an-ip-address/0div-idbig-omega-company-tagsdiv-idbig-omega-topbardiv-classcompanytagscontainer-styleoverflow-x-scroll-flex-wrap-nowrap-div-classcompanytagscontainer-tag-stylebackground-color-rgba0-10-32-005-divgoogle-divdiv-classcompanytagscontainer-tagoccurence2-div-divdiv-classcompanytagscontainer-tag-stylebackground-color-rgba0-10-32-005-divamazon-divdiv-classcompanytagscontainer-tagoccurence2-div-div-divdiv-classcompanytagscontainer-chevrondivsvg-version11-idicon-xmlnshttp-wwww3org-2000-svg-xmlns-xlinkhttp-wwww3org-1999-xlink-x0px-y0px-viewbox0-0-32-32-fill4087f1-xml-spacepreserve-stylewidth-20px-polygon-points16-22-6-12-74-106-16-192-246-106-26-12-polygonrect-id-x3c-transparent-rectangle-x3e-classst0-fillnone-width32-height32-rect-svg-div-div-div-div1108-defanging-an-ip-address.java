class Solution {
    public String defangIPaddr(String address) {
        int n=address.length();
        String ans="";
       // int i=0;
        
        for(int i=0;i<address.length();i++)
        {
            if(address.charAt(i)=='.')
            {
                ans += "[.]";
            }
            else
            {
                ans += address.charAt(i);
            }
        }
        
        return ans;
    }
}