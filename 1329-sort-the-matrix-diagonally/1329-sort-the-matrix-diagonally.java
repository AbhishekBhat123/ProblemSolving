// class Solution {
//     public int[][] diagonalSort(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int output[][] = new int[m][n];

//         int colboundary = mat[0][n-1];
//         int rowboundary = 0;

//         // this loop for outer boundary
//         while(colboundary <n && rowboundary <m ){
            
//             // create a temp arraylist for storing the value to sort
//             List<Integer> temp = new ArrayList<>();
//             // this loop for moving diagonal and storing those values inside the array
//             int row = rowboundary;
//             int col = colboundary;
//             while(row <m && col>=0){
//                 temp.add(mat[row][col]);
//                 row++;
//                 col--;
//             }
//             Collections.sort(temp);
//             // for adding the values to the perticular indexes for the o/p array
//             row = rowboundary;
//             col = colboundary;
//             int i = 0;
//             while(row <m && col>=0){
                
//                 output[row][col] = temp.get(i);
//                 i++;
//                 row++;
//                 col--;
//             } 

//             // decrement 
//             colboundary--;
//             // the condition where the main colboundaries got to the boundaries
//             if (colboundary == 0 ){
//                 rowboundary++;
//             }
//         }

//         return output;
//     }
// }
// the above approach is good in logic but has more issue 

// this is the good code of the same logic which has TC: O(mnlogmin(mn)) and SC:(Omin(mn))
// class Solution {
//     public int[][] diagonalSort(int[][] mat) {
    
//     int m = mat.length;
//     int n = mat[0].length;

    // for(int startcolumn = 0; startcolumn < n; startcolumn++){
    //     sort(mat,0,startcolumn,m,n);
    // }

    // for(int startrow = 1; startrow < m; startrow++){
    //     sort(mat,startrow,0,m,n);
    // }
     
    //  return mat;

//  }

//     private void sort(int mat[][], int row, int col, int m, int n){
//         List<Integer> temp = new ArrayList<>();
//         int r = row;
//         int c = col;

//         while(r<m && c<n){
//             temp.add(mat[r][c]);
//             r++;
//             c++;
//         }
//         int i = 0;
//         Collections.sort(temp);

//         r = row;
//         c = col;
//         while(r<m && c<n){
//             mat[r][c] = temp.get(i);
//             i++;
//             r++;
//             c++;
//         }
//     }
// }



// the optimal approach for this will be using count sort
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Diagonals starting from the top row
        for (int col = 0; col < n; col++) {
            sortDiagonal(mat, 0, col, m, n);
        }

        // Diagonals starting from the left column
        // Start from 1 because (0,0) was already handled
        for (int row = 1; row < m; row++) {
            sortDiagonal(mat, row, 0, m, n);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col, int m, int n) {

        // 1. Count frequency of each value
        int[] count = new int[101];

        int r = row;
        int c = col;

        while (r < m && c < n) {
            count[mat[r][c]]++;
            r++;
            c++;
        }

        // 2. Put values back in sorted order
        r = row;
        c = col;

        for (int value = 1; value <= 100; value++) {
            while (count[value] > 0) {
                mat[r][c] = value;

                r++;
                c++;
                count[value]--;
            }
        }
    }
}