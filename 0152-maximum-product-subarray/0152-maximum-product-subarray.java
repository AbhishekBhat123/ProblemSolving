// class Solution {
//     public int maxProduct(int[] nums) {
//         int n = nums.length;
//         int pref[] = new int[n];

//         pref[0] = nums[0];
//         for(int i = 1; i<n; i++){
//             pref[i] = pref[i-1] * nums[i];
//         }

//         int maxProd = 0;
//         int prod = 0;
//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 if(i==0){prod = pref[j];}
//                 else{
//                     if(pref[i-1]!=0){prod = pref[j] / pref[i-1];}
//                     maxProd = Math.max(maxProd, prod);
//                 }
//             }
//         }

//         return maxProd;
//     }
// }
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            // Save old values because both are needed
            int oldMax = maxProd;
            int oldMin = minProd;

            maxProd = Math.max(x, Math.max(x * oldMax, x * oldMin));
            minProd = Math.min(x, Math.min(x * oldMax, x * oldMin));

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}
