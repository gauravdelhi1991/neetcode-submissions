class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Set<String> visited = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    count++;
                    dfs(grid, i, j, rows, cols, visited);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col, int rows, int cols, Set<String> visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || visited.contains(row + "," + col)) return;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        visited.add(row + "," + col);

        for (int[] direction : directions) {
            dfs(grid, row + direction[0], col + direction[1], rows, cols, visited);
        }
    }
}
