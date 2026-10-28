class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }

        StringBuilder[] res = new StringBuilder[numRows];
        for(int i = 0; i<numRows; i++){
            res[i] = new StringBuilder();
        }

        int direction = 1;
        int row = 0;

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            res[row].append(c);
            if(row == numRows - 1){
                direction = -1;
            }
            else if(row == 0){
                direction = 1;
            }

            row += direction;
        }

        StringBuilder ans = new StringBuilder();
        for(int i =0 ; i<numRows; i++){
            ans.append(res[i]);
        }
        return ans.toString();
    }
}