// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         // brute force approach is O(n^2) just use 2 lops
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int row = 0;
//         int col = m - 1;
//         while(row<n && col>=0){
//             int matrixes = matrix[row][col];
//             if( matrixes == target){return true;}
//             else if(matrixes < target){
//                 row++;
//             }
//             else{col--;}
//         }
//         return false;
//     }
// }

// Optimal but not worked 
// Line 25-33: Creating a flattened array copy takes O(m * n) time, which is explicitly prohibited.
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int[] temp = new int[m*n];
//         int k = 0;

//         for(int i = 0; i<n; i++){
//             for(int j = 0; j<m; j++){
//                 temp[k] = matrix[i][j];
//                 k++;
//             }
//         }

//         int left = 0;
//         int right = temp.length - 1;

//         while(left<=right){
//             int mid = left + (right - left)/2;
//             if(temp[mid] == target){return true;}
//             else if(temp[mid] < target){
//                 left = mid + 1;
//             }
//             else{right = mid - 1;}
//         }
//         return false;
//     }
// }


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m *n - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            // to find where actually mid value pointed in both row and col 
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target){return true;}
            else if(matrix[row][col] < target){
                left = mid + 1;
            }
            else{right = mid - 1;}
        }
        return false;
    }
}