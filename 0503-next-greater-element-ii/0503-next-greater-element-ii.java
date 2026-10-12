//  class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n = nums.length;
//         Stack<Integer> stk = new Stack<>();
//         int PGE[] = new int[n];
//         int NGE[] = new int[n];
//         int ans[] = new int[n];

//         for(int i =0; i<n; i++){
//             while(!stk.isEmpty() && nums[stk.peek()] <= nums[i] ){
//                 stk.pop();
//             }

//             if(stk.isEmpty()){
//                 PGE[i] = -1;
//             }
//             else{
//                 PGE[i] = nums[stk.peek()];
//             }

//             stk.push(i);
//         }
//         stk.clear();

//         for(int i =n-1; i>=0; i--){
//             while(!stk.isEmpty() && nums[stk.peek()] <= nums[i] ){
//                 stk.pop();
//             }

//             if(stk.isEmpty()){
//                 NGE[i] = -1;
//             }
//             else{
//                 NGE[i] = nums[stk.peek()];
//             }

//             stk.push(i);
//         }

//         for(int i = 0; i<n; i++){
//             int max = Math.max(NGE[i], PGE[i]);
//             ans[i] = max;
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stk = new Stack<>();

        // Traverse the array twice to simulate circular movement
        for (int i = 0; i < 2 * n; i++) {

            // Convert the loop index into an actual array index
            int idx = i % n;

            // Resolve elements that are smaller than the current element
            while (!stk.isEmpty() &&
                   nums[stk.peek()] < nums[idx]) {

                int prevIndex = stk.pop();
                ans[prevIndex] = nums[idx];
            }

            // Push each original index only once
            if (i < n) {
                stk.push(idx);
            }
        }

        return ans;
    }
}