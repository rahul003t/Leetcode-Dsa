class Solution {

    final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                max += 1;
            }
        }
        int curr = max;
        for (int r = k, l = 1;  r < s.length(); r++, l++) {
            if (vowels.contains(s.charAt(l - 1))) {
                curr--;
            }
            if (vowels.contains(s.charAt(r))) {
                curr++;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}