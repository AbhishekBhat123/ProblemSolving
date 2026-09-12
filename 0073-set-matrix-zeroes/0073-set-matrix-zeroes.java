// // here i faced the problem is whenever i found first 0 i am going toinsert 0s but it will affect to the existing vlaues
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;

//         for(int i = 0; i<n; i++){
//             for(int j = 0; j<m; j++){
//                 if(matrix[i][j] == 0){
//                     // first for row 
//                     int k = 0;
//                     int l = 0;
//                     while(k<m){
//                         matrix[i][k] = 0;
//                         k++;
//                     }

//                     // 2nd loop
//                     while(l<n){
//                         matrix[l][j] = 0;
//                         l++;
//                     }
//                 }
//             }
//         }
//     }
// }



// works but here we used extra space
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;

//         boolean row[] = new boolean[n];
//         boolean col[] = new boolean[m];

//         // storing i and j values
//         for(int i = 0; i<n; i++){
//             for(int j = 0; j<m; j++){
//                 if(matrix[i][j] == 0){
//                     row[i] = true;
//                     col[j] = true;
//                 }
//             }
//         }

//         // now pushing that zeros to all row and cols
//         for(int i = 0; i<n; i++){
//             if(row[i]){
//                 for(int j = 0; j<m; j++){
//                     matrix[i][j] = 0;
//                 }
//             }
//         }


//         for(int i = 0; i<m; i++){
//             if(col[i]){
//                 for(int j = 0; j<n; j++){
//                     matrix[j][i] = 0;
//                 }
//             }
//         }        




//     }
// }




// marker method optimal
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstrow = false;
        boolean firstcol = false;

        // s1. we have to check first row is 0?
        for(int j = 0; j<m; j++){
            if(matrix[0][j] == 0){
                firstrow = true;
            }
        }

        // s2. this is for col
        for(int i = 0; i<n; i++){
            if(matrix[i][0] == 0){
                firstcol = true;
            }
        }


        // s3.now to check from inside the matrix and here we start from 1 becasue we are stored row 0 and col 0 as markers so they are not real 0 so if i counted them put that whole row/col as 0 then issue  
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(matrix[i][j] == 0){
                    // applying marker the 0 value
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // s4. now apply those marker to make all row 0
        for(int i = 1; i<n; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j<m; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // s5. now apply those marker to make col as 0
        for(int j=1; j<m; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i<n; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstrow){
            for(int j = 0; j<m; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstcol){
            for(int i = 0; i<n; i++){
                matrix[i][0] = 0;
            }
        }        
    }
}


