class Solution {
    public char findTheDifference(String s, String t) {
        
        char sum=0;
        for(int i=0;i<t.length();i++){
            sum+=t.charAt(i);
        }
         for(int i=0;i<s.length();i++){
             sum-=s.charAt(i);
         }   
            
        return (char)sum;
        
    }
}