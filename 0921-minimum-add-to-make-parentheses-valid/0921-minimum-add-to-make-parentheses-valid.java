// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> stk = new Stack<>();
//         for(char ch : s.toCharArray()){
//             if(ch == '('){
//                 stk.push(ch);
//             }
//             else {
//                 if(!stk.isEmpty() && stk.peek() == '('){
//                     stk.pop();
//                 }
//                 else{
//                     stk.push(')');
//                 }
//             }
//         }
//         return stk.size();
//     }
// }

// or this works here

// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> stack = new Stack<>();

//         for (char c : s.toCharArray()) {
//             if (c == ')' && !stack.isEmpty()
//                     && stack.peek() == '(') {
//                 stack.pop();
//             } else {
//                 stack.push(c);
//             }
//         }

//         return stack.size();
//     }
// }


// Optimal

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int insertions = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    insertions++;
                }
            }
        }

        return open + insertions;
    }
}
