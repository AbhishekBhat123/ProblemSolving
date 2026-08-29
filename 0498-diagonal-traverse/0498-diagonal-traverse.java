// class Solution {
//     public int[] findDiagonalOrder(int[][] mat) {
//         int row = 0;
//         int col = 0;
//         boolean istop = true;
//         int idx = 0;

//         int m = mat.length;
//         int n = mat[0].length;

//         int[] ans = new int[m * n];

//         while (idx < m * n) {

//             if (istop) {
//                 while (row >= 0 && col < n) {
//                     ans[idx++] = mat[row][col];
//                     row--;
//                     col++;
//                 }

//                 // Adjust position after reaching boundary
//                 if (col == n) {
//                     col--;
//                     row += 2;
//                 } else {
//                     row++;
//                 }

//                 istop = false;
//             } 
//             else {
//                 while (row < m && col >= 0) {
//                     ans[idx++] = mat[row][col];
//                     row++;
//                     col--;
//                 }

//                 // Adjust position after reaching boundary
//                 if (row == m) {
//                     row--;
//                     col += 2;
//                 } else {
//                     col++;
//                 }

//                 istop = true;
//             }
//         }

//         return ans;
//     }
// }




class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = 0;
        int col = 0;
        int index = 0;
        int m = mat.length;
        int n = mat[0].length;
        int output[] = new int [m*n];
        boolean isgoingtop = true;

        while(index < m*n){

            if(isgoingtop){
                while(row>= 0 && col<n){
                    output[index++] = mat[row][col];
                    row--;
                    col++;
                }
                    if(col == n){
                        row+= 2;
                        col--;
                    }
                    else{row++;}
                    isgoingtop = false;
                
            }
            else{
                while(row<m && col>=0){
                    output[index++] = mat[row][col];
                    row++;col--;
                }
                    if(row == m){
                        col += 2;
                        row--;
                    }
                    else{
                        col++;
                    }
                    isgoingtop = true;
                
            }

            
        }
            return output;
    }
}