// we are solving this using dfs method
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, m, n,i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char grid[][], int m, int n, int i, int j){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == '0')
        {
            return;
        }

        grid[i][j] = '0';

        dfs(grid,m,n,i-1,j); //up
        dfs(grid,m,n,i+1,j); // down
        dfs(grid,m,n,i,j-1); // left
        dfs(grid,m,n,i,j+1); // right
    }
}