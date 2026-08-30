// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         // the brute force approach is to use 2 loops for getting the range of subarrays and we use carry forward approach 

//         int n = nums.length;
//         int sum;
//         int cnt = 0;
//         for(int i = 0; i<n; i++){
//              sum = 0;
//             for(int j = i; j<n; j++){
//                 sum += nums[j];
//                 if(sum == k){cnt++;}
//             }
//         }
//         return cnt;
//     }
// }

// class Solution {
//     public int subarraySum(int[] nums, int k) {
        
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         // Prefix sum 0 has occurred once
//         map.put(0, 1);
        
//         int pfSum = 0;
//         int cnt = 0;

//         for (int i = 0; i < nums.length; i++) {
//             pfSum += nums[i];

//             int needed = pfSum - k;

//             // If needed prefix sum exists, add its frequency
//             if (map.containsKey(needed)) {
//                 cnt += map.get(needed);
//             }

//             // Store/increase frequency of current prefix sum
//             map.put(pfSum, map.getOrDefault(pfSum, 0) + 1);
//         }

//         return cnt;
//     }
// }




class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = nums.length;
        int pref[] = new int[n];
        int cnt = 0;
        
        pref[0] = nums[0];
        for(int i = 1; i<n; i++){
            pref[i] = pref[i-1] + nums[i];
        }

        map.put(0,1);

        for(int i = 0; i<n; i++){
            int needed = pref[i] - k;
            if(map.containsKey(needed)){
                cnt += map.get(needed);
            }

            map.put(pref[i], map.getOrDefault(pref[i], 0)+1);
        }

        return cnt;

            
    }
}
