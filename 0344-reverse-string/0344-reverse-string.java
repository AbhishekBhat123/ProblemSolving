// class Solution {
//     public void reverseString(char[] s) {
//         int n = s.length;
//         int left = 0;
//         int right = n-1;
//         char tmp = 0;

//         while(left<right){
//             tmp = s[right];
//             s[right] = s[left];
//             s[left] = tmp;
//             left++;
//             right--;
//         }
//         System.out.print(Arrays.toString(s));
        
//     }
// }




class Solution {
    private void reverse(char[] s, int st, int e){
        if(st>e){
            return;
        }
        char temp = s[st];
        s[st] = s[e];
        s[e] = temp;
        reverse(s, st+1, e-1);
    }
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);

    }
}