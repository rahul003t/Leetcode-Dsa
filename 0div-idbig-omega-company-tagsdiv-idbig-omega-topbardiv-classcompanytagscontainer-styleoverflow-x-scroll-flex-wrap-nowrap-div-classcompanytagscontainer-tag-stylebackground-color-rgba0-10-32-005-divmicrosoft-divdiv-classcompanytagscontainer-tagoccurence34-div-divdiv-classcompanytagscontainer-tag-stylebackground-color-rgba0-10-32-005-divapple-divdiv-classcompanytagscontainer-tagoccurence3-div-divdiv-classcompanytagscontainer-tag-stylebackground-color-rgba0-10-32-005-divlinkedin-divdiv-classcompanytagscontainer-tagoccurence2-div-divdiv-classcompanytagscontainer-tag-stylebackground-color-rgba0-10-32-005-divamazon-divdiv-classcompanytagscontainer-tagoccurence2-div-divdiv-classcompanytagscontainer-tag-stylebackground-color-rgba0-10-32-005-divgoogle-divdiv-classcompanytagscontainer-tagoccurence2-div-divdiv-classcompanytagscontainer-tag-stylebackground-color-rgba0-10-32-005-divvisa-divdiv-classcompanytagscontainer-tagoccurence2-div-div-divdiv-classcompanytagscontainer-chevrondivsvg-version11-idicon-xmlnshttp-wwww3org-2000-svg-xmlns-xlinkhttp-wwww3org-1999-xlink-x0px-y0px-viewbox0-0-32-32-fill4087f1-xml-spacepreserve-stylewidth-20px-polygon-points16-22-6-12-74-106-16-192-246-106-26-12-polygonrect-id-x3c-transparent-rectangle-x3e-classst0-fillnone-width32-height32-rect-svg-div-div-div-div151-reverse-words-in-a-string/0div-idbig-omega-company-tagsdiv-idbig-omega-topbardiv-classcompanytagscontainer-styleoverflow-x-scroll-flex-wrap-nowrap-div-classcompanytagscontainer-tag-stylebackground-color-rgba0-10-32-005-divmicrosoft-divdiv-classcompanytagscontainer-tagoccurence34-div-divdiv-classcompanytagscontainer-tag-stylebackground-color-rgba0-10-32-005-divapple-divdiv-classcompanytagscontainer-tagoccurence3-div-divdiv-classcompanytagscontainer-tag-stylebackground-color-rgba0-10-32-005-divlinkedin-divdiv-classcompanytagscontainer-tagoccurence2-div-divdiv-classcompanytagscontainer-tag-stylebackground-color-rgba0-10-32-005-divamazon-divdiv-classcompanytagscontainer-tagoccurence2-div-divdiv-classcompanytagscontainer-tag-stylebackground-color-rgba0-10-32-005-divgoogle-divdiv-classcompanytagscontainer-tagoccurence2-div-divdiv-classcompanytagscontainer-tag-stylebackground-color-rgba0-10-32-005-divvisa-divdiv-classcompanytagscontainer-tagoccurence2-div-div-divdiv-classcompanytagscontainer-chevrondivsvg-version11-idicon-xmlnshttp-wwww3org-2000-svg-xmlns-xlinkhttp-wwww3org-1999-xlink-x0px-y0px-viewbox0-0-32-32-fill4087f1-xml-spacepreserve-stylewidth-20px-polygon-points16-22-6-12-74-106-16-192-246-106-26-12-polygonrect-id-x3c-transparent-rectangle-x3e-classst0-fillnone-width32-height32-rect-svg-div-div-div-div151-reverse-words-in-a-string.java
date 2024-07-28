class Solution {
    public String reverseWords(String s) {
         String trimmed = s.trim();
            String [] words = trimmed.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for(int i = words.length-1;i>=0;i--){
                sb.append(words[i]);
                if(i>0){
                    sb.append(" ");
                }
            }
      return sb.toString();

    }
}
    