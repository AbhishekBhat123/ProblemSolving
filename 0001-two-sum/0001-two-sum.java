// brute force approach
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length; 
//         for(int i = 0; i<n; i++){
//           for(int j = i+1;j<n; j++){
//             if(nums[i] + nums[j] == target){
//                 return new int[]{i,j};
//             }
//           }
//         }
//         return new int[]{};
//     }
// }


// Optimal one
    class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>();
        int needed = 0;
        for(int i =0; i<n; i++){
            needed = target - nums[i];

            if(map.containsKey(needed)){
                return new int[]{i,map.get(needed)};
            }
            else{
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}