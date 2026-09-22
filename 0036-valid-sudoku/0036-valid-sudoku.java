// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         int n = board.length;
//         int m = board[0].length
//         // first now check all the rows were unique or not 
//         for(int i = 0; i<n; i++){
//             HashSet<char> hs = new HashSet<>();
//             for(int j = 0; j<m; j++){
//                 if(board[i][j] == '.'){continue;}
//                 if(hs.contains(board[i][j])){
//                     return false;
//                 }
//                 hs.add(board[i][j]);
//             }
//         }

//         // this is to check for all the columns
//             for(int i = 0; i<m; i++){
//             HashSet<char> hs = new HashSet<>();
//             for(int j = 0; j<n; j++){
//                 if(board[j][i] == '.'){continue;}
//                 if(hs.contains(board[j][i])){
//                     return false;
//                 }
//                 hs.add(board[i][j]);
//             }
//         }

//         // this code for to check each boxes
//         int count = 0;

//         while(count <3){
            
//         }
//     }
// }


class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        // create hashset for array
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] column = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        // Assign each hashset to the array
        for(int i = 0; i<9; i++){
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        // main logic
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                char digit = board[i][j];
                
                if(digit == '.'){
                    continue;
                }

                int boardIndex = (i/3) * 3 + (j/3);

                if(row[i].contains(digit) || column[j].contains(digit) || box[boardIndex].contains(digit)){
                    return false;
                }

                row[i].add(digit);
                column[j].add(digit);
                box[boardIndex].add(digit);
            }
        }
        return true;
    }
}