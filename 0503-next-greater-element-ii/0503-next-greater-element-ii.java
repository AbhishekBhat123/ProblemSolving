// class Solution {
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
        Stack<Integer> stk = new Stack<>();

        Arrays.fill(ans, -1);

        // Traverse the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            while (!stk.isEmpty() && nums[stk.peek()] <= nums[index]) {
                stk.pop();
            }

            if (i < n && !stk.isEmpty()) {
                ans[index] = nums[stk.peek()];
            }

            stk.push(index);
        }

        return ans;
    }
}
