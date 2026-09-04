// this is the bf for using O(n^3) and i even made bf approach with it takes approach O(n^2)
// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int n = arr.length;
//         long sum = 0;
        

//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 int min = Integer.MAX_VALUE; 
//                 for(int k = i; k<= j; k++){
//                     min = Math.min(min, arr[k]);
//                 }
//                 sum += min;
//             }
//         }
//         return sum;
//     }
// }


// Opptimal approach with contribution and monotomic stack 
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int sum = 0;
        long MOD = 1_000_000_007L;
        int[] left = new int[n];
        int[] right = new int[n];

        // first create the stack to store PSE where store left[i] the index of its PSE if not found then make it as -1

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!stk.isEmpty() && arr[stk.peek()] > arr[i]){
                stk.pop();
            }

            if(stk.isEmpty()){
                // here if the stack is empty then we are going to store subtract with -1 that is however +1 so below i - PSE where pse=-1
                left[i] = i+1;
            }
            else{
                // storing the distance of the left boundary it consitst
                left[i] = i - stk.peek();
            }

            // finally we are pushing the data for the future use
            stk.push(i);
        }

        stk.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stk.isEmpty()
                    && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = stk.peek() - i;
            }

            stk.push(i);
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {

            long contribution =
                    (long) arr[i]
                    * left[i]
                    * right[i];

            answer = (answer + contribution) % MOD;
        }

        return (int) answer;
    }
}