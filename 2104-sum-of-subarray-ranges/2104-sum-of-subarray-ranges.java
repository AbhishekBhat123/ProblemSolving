// class Solution {
//     public long subArrayRanges(int[] nums) {
//         int n = nums.length;
//         int max = 0;
//         int min = 0;
//         long sum = 0;

//         for(int i = 0; i<n; i++){
//             min = nums[i];
//             max= nums[i];
//             for(int j= i; j<n; j++){
//                 min = Math.min(min, nums[j]);
//                 max = Math.max(max, nums[j]);

//                 sum += max - min;
//             }
//         }
//         return sum;
//     }
// }

// Optmial
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int max = 0;
        int min = 0;
        long sum = 0;

        int[] PSE = new int[n];
        int[] NSE = new int[n];

        int[] PGE = new int[n];
        int[] NGE = new int[n];

        // for to create NSE
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!stk.isEmpty() && nums[stk.peek()] > nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                PSE[i] = i+1;
            }
            else{
                PSE[i] = i - stk.peek();
            }

            stk.push(i);
        }

        // to create PSE
        stk.clear(); 
        for(int i = n-1; i>=0; i--){
            while(!stk.isEmpty() && nums[stk.peek()] >= nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                NSE[i] = n-i;
            }
            else{
                NSE[i] = stk.peek() - i;
            }

            stk.push(i);
        }

        // for to create PGE 
        stk.clear();
        for(int i = 0; i<n; i++){
            while(!stk.isEmpty() && nums[stk.peek()] < nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                PGE[i] = i+1;
            }
            else{
                PGE[i] = i - stk.peek();
            }

            stk.push(i);
        }

        // for to create the NGE
        stk.clear(); 
        for(int i = n-1; i>=0; i--){
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                NGE[i] = n-i;
            }
            else{
                NGE[i] = stk.peek() - i;
            }

            stk.push(i);
        }


        // final 
        for(int i = 0; i<n; i++){
            long minsum = PSE[i] * NSE[i];
            long maxsum = PGE[i] * NGE[i];

            sum += nums[i] * (maxsum - minsum);
        }

        return sum;
    }
}