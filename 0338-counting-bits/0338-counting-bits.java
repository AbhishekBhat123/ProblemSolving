// class Solution {
//     public int[] countBits(int n) {
//         int ans[] = new int[n+1];
//         int idx = 1;
//         for(int i = 1; i<=n; i++){
//             int val = i;
//             int cnt = 0;
//             while(val>0){
//                 if((val & 1) == 1){
//                     cnt++;
//                 }
//                 val = val>>1;
//             }
//             ans[idx++] = cnt;
//         }
//         return ans;
//     }
// }

// better than previous but in the worst case both has same tc
// class Solution {
//     public int[] countBits(int n) {
//         int ans[] = new int[n+1];
//         int idx = 1;
//         for(int i = 1; i<=n; i++){
//             int val = i;
//             int cnt = 0;
//             while(val>0){
//                 val = val & (val - 1);
//                 cnt++;
//             }
//             ans[idx++] = cnt;
//         }
//         return ans;
//     }
// }


// full optimal
class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i = 1; i<=n; i++){
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }
}