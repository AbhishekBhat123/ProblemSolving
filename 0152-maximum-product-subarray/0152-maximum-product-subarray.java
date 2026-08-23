// class Solution {
//     public int maxProduct(int[] nums) {
//         int n = nums.length;
//         int prod = 1;
//         int maxProd = 0;

//         for(int i = 0; i<n; i++){
//             prod = 1;
//             for(int j = i; j<n; j++){
//                 prod *= nums[j];
//                 maxProd = Math.max(prod, maxProd);
//             }
//         }

//         return maxProd;
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            int oldMax = max;
            int oldMin = min;

            max = Math.max(x, Math.max(x * oldMax, x * oldMin));
            min = Math.min(x, Math.min(x * oldMax, x * oldMin));

            ans = Math.max(ans, max);
        }

        return ans;
    }
}