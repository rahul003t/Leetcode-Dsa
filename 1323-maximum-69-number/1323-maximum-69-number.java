class Solution {
    public int maximum69Number (int num) {
        
        String valueOf = ""+num;
        return Integer.valueOf(String.valueOf(num).replaceFirst("6","9")).intValue();
    }
}