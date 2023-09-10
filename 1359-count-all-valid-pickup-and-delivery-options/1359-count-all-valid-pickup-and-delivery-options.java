class Solution {

    private int MOD = (int)1e9 + 7;  // Modulus for calculations
    private static final int MAX_PAIRS = 510; // Maximum possible pairs value
    private long[] memoization = new long[MAX_PAIRS];  // Memoization array to store computed values

    private long calculateOrdersCount(long remainingPairs) {
        // Base case: No remaining pairs, return 1
        if (remainingPairs == 0)
            return 1;

        // Check if the value is already computed and return it
        if (memoization[(int)remainingPairs] != -1)
            return memoization[(int)remainingPairs];

        // Calculate the number of valid orders for the remaining pairs
        long currentResult = calculateOrdersCount(remainingPairs - 1) * (2 * remainingPairs - 1) * remainingPairs % MOD;

        // Store the result in the memoization array and return it
        return memoization[(int)remainingPairs] = currentResult;
    }

    public int countOrders(int numPairs) {
        // Initialize the memoization array with -1 values
        for(int i = 0 ; i < numPairs + 5 ; i ++){
            memoization[i] = -1 ;
        }

        // Calculate and return the count of valid orders
        return (int)calculateOrdersCount(numPairs);
    }
}
