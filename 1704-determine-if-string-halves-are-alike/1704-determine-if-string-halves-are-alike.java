class Solution {
    public boolean halvesAreAlike(String s) {
        
        int n = s.length();
        int vowel1=0;
        int vowel2=0;
        
        for(int i=0;i<n/2;i++)
        {
            char ch = s.charAt(i);
            if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch =='U' )
            {
                vowel1++;
            }
            
        } 
        
        for(int i=n/2;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch =='U' || ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                vowel2++;
            }
         }
        
        
        return (vowel1 == vowel2);
        
    }
}