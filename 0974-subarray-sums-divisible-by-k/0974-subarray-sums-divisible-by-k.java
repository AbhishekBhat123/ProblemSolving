// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
        
//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 int sum = 0;
//                 for(int l = i; l<=j; l++){
//                     sum += nums[l];
//                 }
//                 if(sum % k == 0){cnt++;}
//             }
//         }
//         return cnt;
//     }
// }


// BF:2 using pf[] and 2 loops
// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
//         int pref[] = new int[n];
//         pref[0] = nums[0];

//         // create pref array
//         for(int i = 1; i<n; i++){
//             pref[i] = pref[i-1] + nums[i];
//         }


//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 int sum = 0;
//                 if(i==0){sum = pref[j];}
//                 else{sum = pref[j] - pref[i-1];}
//                 if(sum % k == 0){cnt++;}
//             }
//         }
//         return cnt;
//     }
// }


class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 has occurred once before we start.
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            int remainder = prefixSum % k;

            // Java can give negative remainders
            if (remainder < 0) {
                remainder += k;
            }

            // Every previous occurrence of this remainder
            // forms a valid subarray ending here.
            count += map.getOrDefault(remainder, 0);

            // Record this remainder
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}