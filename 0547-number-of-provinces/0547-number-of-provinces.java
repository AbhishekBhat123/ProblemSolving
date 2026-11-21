// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int count = 0;
//         for(int i =0; i<isConnected.length; i++){
//             for(int j = 0; j<isConnected[0].length; j++){
//                 if(isConnected[i][j] == 1){
//                     count++;
//                     dfs(isConnected, i, j);
//                 }
//             }
//         }
//         return count;
//     }
//     private void dfs(int[][] isConnected, int i, int j){
//         if(i<0 || i>= isConnected.length ||
//            j<0 || j>=isConnected[0].length ||
//            isConnected[i][j] == 0){
//             return;
//         }
//         isConnected[i][j] = 0;
//         dfs(isConnected, i-1, j);
//         dfs(isConnected, i+1, j);
//         dfs(isConnected, i, j-1);
//         dfs(isConnected, i, j+1);
//     }
// }
// this has issue
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] != 0) {
                count++;
                dfs(isConnected, i);
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, int i) {

        isConnected[i][i] = 0;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                dfs(isConnected, j);
            }
        }
    }
}