// simple carry forward approach
// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n = nums.length;
//         int sum = 0;
//         int cnt = 0;


//         for(int i = 0; i<n; i++){
//             sum = 0;
//             for(int j = i; j<n; j++){
//                 sum += nums[j];

//                 if(sum == goal){cnt++;}
//             }
//         }
//         return cnt;
//     }
// }

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int needed = prefixSum - goal;

            if (map.containsKey(needed)) {
                count += map.get(needed);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
