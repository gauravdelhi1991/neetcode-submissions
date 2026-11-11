class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int count = dfs(grid, i, j, rows, cols, visited);
                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int row, int col, int rows, int cols, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || visited[row][col]) return 0;

        visited[row][col] = true;

        int count = 0;

        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int[] direction : directions) {
            count += dfs(grid, row + direction[0], col + direction[1], rows, cols, visited);
        }

        return 1 + count;
    }
}
