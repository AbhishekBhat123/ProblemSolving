
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Add character to the current row
            rows[row].append(ch);

            // Change direction at the boundaries
            if (row == numRows - 1) {
                direction = -1;
            } else if (row == 0) {
                direction = 1;
            }

            // Move to the next row
            row += direction;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }
}
