class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list representationof the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }

        // Array to track the visited status of each course
        // O: not visited, 1: visiting, 2: visited
        int[] visited = new int[numCourses];

        // Check for cycles in the graph using DFS
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, graph, visited)) {
                return false; // Cycle detected, cannot finish all courses
            }
        }

        return true; // No cycles detected, can finish all courses
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, int[] visited) {
        // If the course is currently being visited, a cycle exists
        if (visited[course] == 1) {
            return true;
        }

        // If the course has already been visited, no cycle exists
        if (visited[course] == 2) {
            return false;
        }

        // Mark the course as visiting
        visited[course] = 1;

        // Check prerequisites for the current course
        for (int prerequisiteCourse : graph.get(course)) {
            if (hasCycle(prerequisiteCourse, graph, visited)) {
                return true; // Cycle detected
            }
        }

        // Mark the course as visited
        visited[course] = 2;

        return false;
    }
}