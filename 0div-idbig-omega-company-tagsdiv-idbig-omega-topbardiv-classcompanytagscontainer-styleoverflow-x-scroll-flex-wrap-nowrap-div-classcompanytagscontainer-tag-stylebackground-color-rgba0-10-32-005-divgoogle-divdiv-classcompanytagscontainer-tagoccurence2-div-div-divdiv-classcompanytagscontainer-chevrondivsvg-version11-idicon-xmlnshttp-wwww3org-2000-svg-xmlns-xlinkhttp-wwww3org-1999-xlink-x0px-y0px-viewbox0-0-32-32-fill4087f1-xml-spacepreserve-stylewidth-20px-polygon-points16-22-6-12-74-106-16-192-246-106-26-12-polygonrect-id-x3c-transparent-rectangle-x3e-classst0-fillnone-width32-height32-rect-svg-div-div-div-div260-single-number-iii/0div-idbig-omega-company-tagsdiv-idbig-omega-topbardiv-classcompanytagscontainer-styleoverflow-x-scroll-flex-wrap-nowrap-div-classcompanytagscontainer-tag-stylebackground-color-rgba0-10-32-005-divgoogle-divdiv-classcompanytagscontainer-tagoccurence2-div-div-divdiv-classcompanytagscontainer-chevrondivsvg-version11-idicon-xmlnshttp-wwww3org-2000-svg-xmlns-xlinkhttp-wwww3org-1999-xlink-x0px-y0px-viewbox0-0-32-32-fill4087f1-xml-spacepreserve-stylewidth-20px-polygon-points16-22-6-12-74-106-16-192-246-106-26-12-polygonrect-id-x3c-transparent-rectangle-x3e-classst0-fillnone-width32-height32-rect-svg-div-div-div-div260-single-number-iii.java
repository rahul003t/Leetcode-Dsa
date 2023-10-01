class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int rightmostSetBit = xor & ~(xor - 1);

        int x = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                x ^= num;
            }
        }

        int y = xor ^ x;

        return new int[]{x, y};
    }
}