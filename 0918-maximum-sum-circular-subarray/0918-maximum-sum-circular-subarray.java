// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         int n = nums.length;
//         int maxSum = nums[0];
//         int j = 0;
//         int sum = 1;

//         for(int i = 0; i<n; i++){
//             sum = nums[i];
//             if(i==n-1){j=0;}
//             else{
//                  j =i;
//             }
            
//             while(j!=i){
//                 sum += nums[j];
//                 maxSum = Math.max(maxSum, sum);

//                 if(j == n-1){j=0;}
//                 else{j++;}
//             }
//         }
//         return maxSum;
//     }
// }
// here in the above code i actually the logic is correct but here the problem is the looping things here i got confused so to fix that count used

// here in this brute force approach i had used to get the cycle as (j+1)%n 
// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         int n = nums.length;
//         int maxSum = nums[0];


//         for(int i = 0; i<n; i++){
//             int count = 0;
//             int sum = 0;
//             int j = i;

//             while(count<n){
//                 sum += nums[j];
//                 maxSum = Math.max(maxSum, sum);
//                 j = (j+1)%n;
//                 count++;

//             }
//         }
//         return maxSum;
//     }
// }

// Optimal solution using kadane's algo
// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {

//         int total = 0;

//         // Best subarray ending at current position
//         int currentMax = 0;

//         // Best subarray seen overall
//         int maxSum = nums[0];

//         // Smallest subarray ending at current position
//         int currentMin = 0;

//         // Smallest subarray seen overall
//         int minSum = nums[0];

//         for (int num : nums) {

//             // Find maximum normal subarray
//             currentMax = Math.max(num, currentMax + num);
//             maxSum = Math.max(maxSum, currentMax);

//             // Find minimum normal subarray
//             currentMin = Math.min(num, currentMin + num);
//             minSum = Math.min(minSum, currentMin);

//             // Find total array sum
//             total += num;
//         }

//         // If everything is negative,
//         // circular calculation would incorrectly mean
//         // taking zero elements.
//         if (maxSum < 0) {
//             return maxSum;
//         }

//         // Two possibilities:
//         //
//         // 1. Normal maximum subarray
//         // 2. Circular maximum = total - minimum subarray
//         return Math.max(maxSum, total - minSum);
//     }
// }



class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int n  = nums.length;
        int total = nums[0];
        int curmx = nums[0];
        int curmn = nums[0];
        int  max = nums[0];
        int min = nums[0];

        for(int i = 1; i<n; i++){
             curmx = Math.max(nums[i], curmx + nums[i]);
             max = Math.max(max, curmx);

             curmn = Math.min(nums[i], curmn + nums[i]);
             min = Math.min(min, curmn);

             total += nums[i];
        }

        if(max<0){return max;}

        return Math.max(max, total - min);
    }
}
