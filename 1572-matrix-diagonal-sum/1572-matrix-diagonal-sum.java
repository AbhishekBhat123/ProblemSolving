// class Solution {
//     public int diagonalSum(int[][] mat) {
//         //create the hmap
//         HashMap<String,Integer> map = new HashMap<>();

//         // using obs1 we have to consider all the indices were its i and j th values are same
//         int m = mat.length; 
//         for(int i =0; i<m; i++){
//             map.put(i+"#"+i,mat[i][i]);
//         }

//         // apply obs 2 so here make start and end point for to print the values
//         int start = 0;
//         int end = m - 1;

//         while(start <m && end >=0){
//             map.putIfAbsent(start+"#"+end, mat[start][end]);
//             start++;
//             end--;
//         }
//         int ans = 0;
//         for(int x: map.values()){ans += x;}

//         return ans;
//     }
// }


// Optimal

// class Solution {
//     public int diagonalSum(int[][] mat) {
//         int n = mat.length;
//         int sum = 0;

//         for(int i = 0; i<n; i++){
//             sum += mat[i][i];
//             sum += mat[i][n-i-1];
//         }

//         // if the matrix is odd then only the prim and secondary diagonals are interchanged so we have to remove one value in the middle but this wont happen in even matrix

//         if(n%2 == 1){
//             sum -= mat[n/2][n/2]; // this will find only the intersecting or the middle cell
//         }
//             return sum;
//     }
// }



class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int sum  = 0;
        
        for(int i = 0; i<n; i++){
            sum += mat[i][i];
            sum += mat[i][n-i-1];
        }
        if(m % 2 == 1){
            sum -= mat[n/2][m/2];
        }

        return sum;
    }
}