class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        
        int[] visitedPosition = new int[n];
        int[] globalVisited = new int[n];
        
        int answer = -1;
        
        for (int i = 0; i < n; ++i) {
            visitedPosition[i] = -1;
            globalVisited[i] = -1;
        }
        
        int cycleNumber = 0;
        for (int i = 0; i < n; ++i) {
            if (globalVisited[i] == -1) {
                int counter = 0;
                visitedPosition[i] = counter;
                int j = i, k;
                while (globalVisited[j] == -1) {
                    globalVisited[j] = cycleNumber;
                    k = edges[j];
                    if (k == -1) {
                        break;
                    }
                    
                    if (globalVisited[k] != -1 && globalVisited[k] != cycleNumber) break;
                    
                    if (visitedPosition[k] != -1) {
                        answer = Math.max(answer, counter-visitedPosition[k]+1);
                        break;
                    }
                    visitedPosition[k] = ++counter;
                    j = k;
                }
            }
            cycleNumber++;
        }
        return answer;
    }
}