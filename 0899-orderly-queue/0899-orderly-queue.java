class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            return getSmallestUtil(s);
        }

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private String getSmallestUtil(String s){
        StringBuilder str = new StringBuilder(s);
        String ans = str.toString();
        int i;
        for(i=0;i<s.length();i++){
            Character ch = str.toString().charAt(0);
            str.deleteCharAt(0);
            str.append(ch);
            if(str.toString().compareTo(ans) < 0){
                ans = str.toString();
            }
        }
        return ans;
    }
}