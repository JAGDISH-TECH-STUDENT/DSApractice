class Solution {
    int m, n;
    char[][] grid;
    boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int px, int py, char ch) {
        if (visited[x][y]) return true; // cycle found
        visited[x][y] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (grid[nx][ny] != ch) continue;
            if (nx == px && ny == py) continue; // skip parent
            if (dfs(nx, ny, x, y, ch)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {
            {'a','a','a','a'},
            {'a','b','b','a'},
            {'a','b','b','a'},
            {'a','a','a','a'}
        };
        System.out.println(s.containsCycle(grid)); // true
    }
}
