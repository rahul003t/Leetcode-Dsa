class Solution {
    public String reverseVowels(String s) {
       int i=0,j=s.length()-1;
        char[] c = s.toCharArray();
        
        while(i < j)
        {
            while(i<j && !isVowel(c[i]))
            {
                i++;
            }
            while(i<j && !isVowel(c[j]))
            {
                j--;
            }
            if(i>=j)
            {
                break;
            }
            swap(c,i,j);
                i++;
                j--;
                
        }
        
        return new String(c);
        
     
        
        
    }
    
    public void swap(char[] c,int i, int j)
    {
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }
    
    private boolean isVowel(char w)
     {
        return (w == 'a' || w=='e' || w=='i' || w=='o' || w=='u' || w=='A' || w=='E' || w=='I' || w=='O' ||w=='U');
     }
                    
}