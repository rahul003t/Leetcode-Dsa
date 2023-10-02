public class Solution {
    public boolean winnerOfGame(String colors) {
        int aliceScore = 0;
        int bobScore = 0;

        // Iterate through the colors, excluding the edge pieces
        for (int i = 1; i < colors.length() - 1; i++) {
            char currentColor = colors.charAt(i);
            char prevColor = colors.charAt(i - 1);
            char nextColor = colors.charAt(i + 1);

            // Check if Alice can make a move here
            if (currentColor == 'A' && prevColor == 'A' && nextColor == 'A')
                aliceScore++; // Alice can remove 'A'

            // Check if Bob can make a move here
            else if (currentColor == 'B' && prevColor == 'B' && nextColor == 'B')
                bobScore++; // Bob can remove 'B'
        }

        // Determine the winner based on the scores
        return aliceScore > bobScore;
    }
}