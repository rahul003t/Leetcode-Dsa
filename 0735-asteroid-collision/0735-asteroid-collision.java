class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            int asteroid = asteroids[i];
            while (j>0 && asteroids[j-1]>0 && asteroid<0 && asteroids[j-1] < Math.abs(asteroid)) 
            {j--;}

            if (j==0 || asteroid>0 || asteroids[j-1]<0) 
                asteroids[j++] = asteroid;
            else if(asteroids[j-1] == Math.abs(asteroid)) 
                j--;
        }
        
        int[] result = new int[j];
        System.arraycopy(asteroids, 0, result, 0, j);

        return result;
    }
}