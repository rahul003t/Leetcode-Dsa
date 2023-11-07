public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {

        int n = dist.length; // Number of monsters

        // Calculate the time it takes for each monster to reach the city and store it in the "arrivalTimes" array.
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (int) Math.ceil((double) dist[i] / speed[i]);
            speed[i] = 0; // Initialize the "speed" array to 0 for counting monsters arriving at the same time.
        }

        // Count the number of monsters arriving at each minute.
        for (int arrivalTime : arrivalTimes) {
            if (arrivalTime >= n) continue;
            speed[arrivalTime]++;
        }

        // Calculate the cumulative count of monsters arriving at or before each minute.
        for (int i = 1; i < n; i++) {
            speed[i] += speed[i - 1];

            // If the cumulative count exceeds the current minute, return the maximum number of eliminated monsters.
            if (speed[i] > i) {
                return i;
            }
        }

        // If no game loss occurs, return the total number of monsters, as all of them can be eliminated.
        return n;
    }

}
