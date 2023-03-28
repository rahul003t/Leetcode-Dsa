class Solution {
    int monthly;
    int weekly;
    int daily;
    public int mincostTickets(int[] days, int[] costs) {
        // set pricres
        monthly = costs[2];
        weekly = costs[1];
        daily = costs[0];
        // initialize expiration map: when each potential combination will expire and min at that point
        Map<Integer, Integer> previousExpiration = new HashMap<>();
        previousExpiration.put(days[0] + 1, daily);
        previousExpiration.put(days[0] + 7, weekly);
        previousExpiration.put(days[0] + 30, monthly);
        for (int i = 1; i < days.length; i++) {
            Map<Integer, Integer> currentExpiration = new HashMap<>();
            int minExpired = Integer.MAX_VALUE;
            for (int expiration : previousExpiration.keySet()) {
                if (expiration <= days[i]) {
                    // if expired, then see if this is a min for days[i]
                    minExpired = Math.min(minExpired, previousExpiration.get(expiration));
                } else {
                    // if not expired, then keep calculating it.
                    currentExpiration.put(expiration, previousExpiration.get(expiration));
                }
            }
            // for all previous expired, add new expirations for all 3 potential prices
            int previousDailyValue = previousExpiration.getOrDefault(days[i] + 1, Integer.MAX_VALUE);
            currentExpiration.put(days[i] + 1, Math.min(previousDailyValue, minExpired + daily));
            int previousWeeklyValue = previousExpiration.getOrDefault(days[i] + 7, Integer.MAX_VALUE);
            currentExpiration.put(days[i] + 7, Math.min(previousWeeklyValue, minExpired + weekly));
            int previousMonthlyValue = previousExpiration.getOrDefault(days[i] + 30, Integer.MAX_VALUE);
            currentExpiration.put(days[i] + 30, Math.min(previousMonthlyValue, minExpired + monthly));
            previousExpiration = currentExpiration;
        }

        // Take min from all values
        int min = Integer.MAX_VALUE;
        for (int expiration : previousExpiration.keySet()) {
            min = Math.min(min, previousExpiration.get(expiration));
        }
        return min;
    }
}