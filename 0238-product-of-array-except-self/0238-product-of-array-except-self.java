// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int prod = 1;
//         int ans[] = new int[n];
//         // this loop is for calculating product of each values inside the nums array
//         for(int i = 0; i<n; i++){
//             prod *= nums[i];
//         }


//         // this is for removing perticular value from the prod
//         for(int i = 0; i<n; i++){
//             if(prod != 0){ans[i] = prod / nums[i];}
            
//         }

//         return ans;
//     }
// }

// that actually logics correct but the problem is which gives error on example 2

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: store product of everything to the LEFT
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Pass 2: multiply by product of everything to the RIGHT
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
}