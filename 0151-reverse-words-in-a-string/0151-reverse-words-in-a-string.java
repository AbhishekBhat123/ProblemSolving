// class Solution {
//     public String reverseWords(String s) {
//         int i = s.length() - 1;
//         StringBuilder res = new StringBuilder();
//         while(i >= 0){           
//             while(i>=0 && s.charAt(i) == ' '){
//                 i--;
//             }
//             if(i<0){ break;}
//              StringBuilder ans = new StringBuilder();
//             while(i>=0 && s.charAt(i) != ' '){
//                 ans.append(s.charAt(i));
//                 i--;
//             }
//             // for(int j = ans.length() - 1; j>=0; j--){
//             //     res.append(ans.charAt(j));
//             // }
//             // above code same as below
//             ans.reverse();
//             if (res.length() > 0) {
//                 res.append(' ');
//             }
//             // if(i!=2){
//             //     res.append(' ');
//             // }
//             //if i append here it will append space for every end of word so that will give error so we added above

//             res.append(ans);
//         }
//         return res.toString();
//     }
// }

// above one works space is not O(1)


class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Step 1: Reverse the entire string
        reverse(arr, 0, n - 1);

        // Step 2: Reverse each word
        int start = 0;

        for (int end = 0; end < n; end++) {
            if (arr[end] == ' ') {
                if (start < end) {
                reverse(arr, start, end - 1);
                }
                start = end + 1;
            }
        }

        // Reverse the last word
        reverse(arr, start, n - 1);

        // Step 3: Remove extra spaces and build result
        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < n) {
            // Skip spaces
            while (i < n && arr[i] == ' ') {
                i++;
            }

            if (i >= n) {
                break;
            }

            // Add space only between words
            if (res.length() > 0) {
                res.append(' ');
            }

            // Append the current word
            while (i < n && arr[i] != ' ') {
                res.append(arr[i]);
                i++;
            }
        }

        return res.toString();
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
