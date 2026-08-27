// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
//         int oddcnt = 0;
//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 oddcnt = 0;
//                 for(int l = i; l<=j; l++){
//                     if(nums[l]%2 == 1){oddcnt++;}
//                     if(oddcnt == k){cnt++; break;}

//                 }
//             }
//         }
//         return cnt;
//     }
// }

// brute force approach
// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
//         int oddcnt = 0;
//         for(int i =0; i<n; i++){
//             oddcnt = 0;
//             for(int j = i; j<n; j++){
//                 if(nums[j] % 2 == 1){
//                     oddcnt++;
//                 }
//                 if(oddcnt == k){cnt++; }
//                 if(oddcnt >k){break;}
//             }
//         }

//         return cnt;
//     }
// }


// // optimal
// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int left = 0;
//         int oddCount = 0;
//         int evenCount = 0;
//         int count = 0;

//         for (int right = 0; right < nums.length; right++) {

//             // Add the new element
//             if (nums[right] % 2 == 1) {
//                 oddCount++;
//                 evenCount = 0;
//             } else if (oddCount == k) {
//                 evenCount++;
//             }

//             // Too many odd numbers
//             while (oddCount > k) {
//                 if (nums[left] % 2 == 1) {
//                     oddCount--;
//                 }
//                 left++;
//             }

//             // We have exactly k odd numbers
//             if (oddCount == k) {
//                 count += evenCount + 1;
//             }
//         }

//         return count;
//     }
// }



class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int oddCount = 0;
        int evenBefore = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add nums[right]
            if (nums[right] % 2 == 1) {
                oddCount++;
            }

            // We have more than k odds
            if (oddCount > k) {

                // Move left until we remove the previous odd
                while (nums[left] % 2 == 0) {
                    left++;
                }

                left++;
                oddCount--;

                // New window -> reset the even count
                evenBefore = 0;
            }

            // We have exactly k odds
            if (oddCount == k) {

                // Count even numbers before the first odd
                while (nums[left] % 2 == 0) {
                    evenBefore++;
                    left++;
                }

                // Every possible starting position gives a valid subarray
                count += evenBefore + 1;
            }
        }

        return count;
    }
}
