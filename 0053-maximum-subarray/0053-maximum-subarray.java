// class Solution {
//     public int maxSubArray(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         int maxSum  = 0;

//         int pref[] = new int[n];
//         pref[0] = nums[0];
//         for(int i =1; i<n; i++){
//             pref[i] = pref[i-1] + nums[i];
//         }

//         for(int i = 0; i<n; i++){
//             sum = 0;
//             for(int j = i; j<n; j++){
//                 sum += nums[j];
//                 if (i == 0){sum = pref[j];}
//                 else{sum = pref[j] - pref[i-1];}
//                 maxSum = Math.max(maxSum,sum);
//             }
//         }

//         return maxSum;
//     }
// }

// above approach for the O(n^2) brute force one

// we are using kadanes algo
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        // this is important first value of array other wise i get issue in handling -ve values
        int maxSum  = nums[0];

        for(int i = 0; i<n; i++){
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);

            if(sum<0){sum = 0;}
        }
        return maxSum;
    }
}