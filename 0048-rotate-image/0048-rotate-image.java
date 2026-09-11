class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // finding the transpose by upper half
        for(int i = 0; i<n; i++){
            for(int j=i+1; j<m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse the elements
        int cnt = 0;
        while( cnt <n){
            int i = 0; 
            int j = m-1;

            while(i<=j){
                int temp = matrix[cnt][i];
                matrix[cnt][i] = matrix[cnt][j];
                matrix[cnt][j] = temp;
                j--;
                i++;
            }
            cnt++;
        }
    }
}