// bf works
// class Solution {
//     public int minMoves2(int[] nums) {
//         long min = Integer.MAX_VALUE;
//         int n = nums.length;
//         for(int i = 0; i<n; i++){
//             int sum = 0;
//             for(int j = 0; j<n; j++){
//                 sum += Math.abs((long)nums[i] - nums[j]);
//             }
//             min = Math.min(min, sum);
//         }
//         return (int)min;
//     }
// }

// Optimal by using median to find , intution is : if we get middle element then that is however balanced so if i subtract from any side i will get the min move and it works for both even and odd 

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];

        long sum = 0;

        for (int num : nums) {
            sum += Math.abs((long)num - median);
        }

        return (int)sum;
    }
}