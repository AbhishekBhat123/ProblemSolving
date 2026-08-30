// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {

//         List<Integer> result = new ArrayList<>();

//         // Find the maximum possible diagonal number
//         int maxDiagonal = 0;

//         for (int row = 0; row < nums.size(); row++) {
//             maxDiagonal = Math.max(maxDiagonal, row + nums.get(row).size() - 1);
//         }

//         // Process each diagonal
//         for (int diagonal = 0; diagonal <= maxDiagonal; diagonal++) {

//             // Start from the bottom-most possible row
//             int row = Math.min(diagonal, nums.size() - 1);

//             while (row >= 0) {

//                 int col = diagonal - row;

//                 // Check whether this column exists in this row
//                 if (col < nums.get(row).size()) {
//                     result.add(nums.get(row).get(col));
//                 }

//                 row--;
//             }
//         }

//         // Convert List<Integer> to int[]
//         int[] answer = new int[result.size()];

//         for (int i = 0; i < result.size(); i++) {
//             answer[i] = result.get(i);
//         }

//         return answer;
//     }
// }

// that will give tle


// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {

//         int maxDiagonal = 0;

//         // Find the number of diagonals
//         for (int row = 0; row < nums.size(); row++) {
//             maxDiagonal = Math.max(
//                 maxDiagonal,
//                 row + nums.get(row).size() - 1
//             );
//         }

//         // Create a bucket for every diagonal
//         List<List<Integer>> diagonals = new ArrayList<>();

//         for (int i = 0; i <= maxDiagonal; i++) {
//             diagonals.add(new ArrayList<>());
//         }

//         // Put every element into its diagonal
//         for (int row = 0; row < nums.size(); row++) {

//             for (int col = 0; col < nums.get(row).size(); col++) {

//                 int diagonal = row + col;

//                 diagonals.get(diagonal).add(nums.get(row).get(col));
//             }
//         }

//         // Reverse every diagonal
//         List<Integer> result = new ArrayList<>();

//         for (List<Integer> diagonal : diagonals) {

//             Collections.reverse(diagonal);

//             result.addAll(diagonal);
//         }

//         // Convert to int[]
//         int[] answer = new int[result.size()];

//         for (int i = 0; i < result.size(); i++) {
//             answer[i] = result.get(i);
//         }

//         return answer;
//     }
// }



class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    // first need to find the daigonals 
    int n = nums.size();
    int diagonals = 0;
    for(int i = 0; i<n; i++){
        diagonals = Math.max(diagonals, i + nums.get(i).size()-1);
    }
    // create 2d arraylist to put the data inside to it 
    List<List<Integer>> diagonallist = new ArrayList<>();

    // create the new arraylist to store the diagonals data 
    for(int i = 0; i<=diagonals; i++){
        diagonallist.add(new ArrayList<>());
    }

    // find the sums and fit the values according to the diagonals
    for(int i =0; i<n; i++){
        int m = nums.get(i).size();
        for(int j = 0; j<m; j++){
            int length = i+j;
            diagonallist.get(length).add(nums.get(i).get(j));
        }
    }

    // reverse the values in the each diagonallist and put that to the output array
    List<Integer> ans = new ArrayList<>();

    for(int i = 0; i<diagonallist.size(); i++){
        int row = diagonallist.get(i).size();
        for(int j = row-1; j>=0; j--){
            ans.add(diagonallist.get(i).get(j));
        }
    }

    //transform Al to the output array
    int out[] = new int[ans.size()];

    for(int i = 0; i<ans.size();i++){
        out[i] = ans.get(i);
    }

    return out;

    }
}