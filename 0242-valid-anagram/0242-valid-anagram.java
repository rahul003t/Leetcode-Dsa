class Solution {
    public boolean isAnagram(String s, String t) {
        //int[] f = new int[26];
        
//         for(char c  : s.toCharArray()) f[c -'a']++;
//         for(char c : t.toCharArray()) f[c - 'a']--;
        
//         for(int i: f){
//             if(i != 0){
                
//                 return false;
//             }
//         }
//         return true;
        
        
        HashMap <Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            if(map.containsKey(ch)== false)
            {
                return false;
            }else if(map.get(ch)==1)
            {
                map.remove(ch);               
            }
            else
            {
                map.put(ch, map.get(ch)-1);
            }
        }
        
        return map.size() == 0;
    }
}