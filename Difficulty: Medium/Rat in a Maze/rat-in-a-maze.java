class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
    
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        
        if (maze[0][0] == 1) {
            dfs(maze, 0, 0, n, "", visited, result);
        }
        
        Collections.sort(result);
        return result;
    }
    
    private void dfs(int[][] maze, int i, int j, int n, String path, boolean[][] visited, ArrayList<String> result) {
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }
        
        visited[i][j] = true;
        
        if (isSafe(maze, i + 1, j, n, visited)) dfs(maze, i + 1, j, n, path + "D", visited, result);
        if (isSafe(maze, i, j - 1, n, visited)) dfs(maze, i, j - 1, n, path + "L", visited, result);
        if (isSafe(maze, i, j + 1, n, visited)) dfs(maze, i, j + 1, n, path + "R", visited, result);
        if (isSafe(maze, i - 1, j, n, visited)) dfs(maze, i - 1, j, n, path + "U", visited, result);
        
        visited[i][j] = false;
    }
    
    private boolean isSafe(int[][] maze, int i, int j, int n, boolean[][] visited) {
        return i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j];
    }
}
