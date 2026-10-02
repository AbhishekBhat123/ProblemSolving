// class Solution {
//     public int[] sortArrayByParity(int[] nums) {
//         int n = nums.length;
//         ArrayList<Integer> ans = new ArrayList<>();
//         int res[] = new int[n];
//         for(int i=0; i<n; i++){
//             if(nums[i] % 2 ==0){
//                ans.add(nums[i]);
//             }
//         }
//             for(int i=0; i<n; i++){
//             if(nums[i] % 2 != 0){
//                 ans.add(nums[i]);
//             }
//         }

//             for(int j=0; j<ans.size(); j++){
//                 res[j] = ans.get(j);
//             }
//             return res;
        
//     }
// }


// class Solution {
//     public int[] sortArrayByParity(int[] nums) {
//         int j = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] % 2 == 0) {
//                 int temp = nums[i];
//                 nums[i] = nums[j];
//                 nums[j] = temp;
//                 j++;
//             }
//         }

//         return nums;
//     }
// }

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int idx = 0;
        for(int m: nums){
            if(m%2 == 0){
                ans[idx++] = m;
            }
        }

        for(int m: nums){
            if(m%2 == 1){
                ans[idx++] = m;
            }
        }
        return ans;
    }
}