// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int val = image[sr][sc];
//         // this is to check if the val and colr are same then the recursion infinte times
//         if(val == color){
//             return image;
//         }
//         image[sr][sc] = color;
//         dfs(image, val, sr, sc, color);
//         return image;
//     }
//     int dx[] = {0, 0, -1, 1};
//     int dy[] = {-1, 1, 0, 0};
//     private void dfs(int[][] ans, int val, int i, int j, int color){
//         for(int k = 0; k<4; k++){
//             int x = i + dx[k];
//             int y = j + dy[k];
//             if(x>=0 && y>=0 && x<ans.length && y<ans[0].length && ans[x][y] == val){
//                 ans[x][y] = color;
//                dfs(ans, val, x, y,color);
//             }
//         }
//     }
// }
// or

class Solution {

    int dx[] = {0, 0, -1, 1};
    int dy[] = {-1, 1, 0, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int val = image[sr][sc];

        // Handle the same-color edge case
        if (val == color) {
            return image;
        }

        dfs(image, val, sr, sc, color);

        return image;
    }

    private void dfs(int[][] image, int val, int i, int j, int color) {

        // Mark current cell as visited
        image[i][j] = color;

        // Explore all 4 directions
        for (int k = 0; k < 4; k++) {

            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 &&
                x < image.length && y < image[0].length &&
                image[x][y] == val) {

                dfs(image, val, x, y, color);
            }
        }
    }
}