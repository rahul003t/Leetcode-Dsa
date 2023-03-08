class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0; // fastest possible time to complete all trips
        long r = time[0];
        
        // find the min value in the array
        for (int i = 1; i < time.length; i++) {
            if (r > time[i]) r = time[i];
        }

        // this is the max possible time to complete all trips
        r = r * totalTrips;

        // binary search on range of times to find fastest
        while (l <= r) {
            long mid = l + ((r-l)/2);

            if (valid(time, totalTrips, mid)) {
                // totalTrips can be completed in the time range
                // [mid, r] so the min time must exist in [l, mid]
                r = mid-1;
            } else {
                // totalTrips cannot be completed in time range
                // [l, mid] so min time must exist in (mid, r]
                l = mid+1;
            }
        }
        
        // Because of how the partitioning works, after iterating
        // l will always contain the min value
        return l;
    }

    // Determines if totalTrips can be completed in totalTime
    boolean valid(int[] time, int totalTrips, long totalTime) {
        int trips = 0;

        for (int i = 0; i < time.length; i++) {
            if (time[i] > totalTime) continue;

            trips += (totalTime / time[i]);
            
            if (trips >= totalTrips) return true; // all trips complete
        }

        return false; // totalTrips could not be completed in time
    }
}