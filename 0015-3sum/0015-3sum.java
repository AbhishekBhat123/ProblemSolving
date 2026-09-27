// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> hs = new HashSet<>();
//         int n = nums.length;

//         for(int i =0; i<n; i++){
//             for(int j= i+1; j<n; j++){
//                 for(int k = j+1; k<n; k++){
//                     if(nums[i] + nums[j] + nums[k] == 0){
//                         List<Integer> ans = new ArrayList<>();
//                         ans.add(nums[i]);
//                         ans.add(nums[j]);
//                         ans.add(nums[k]);
//                         Collections.sort(ans);
//                         hs.add(ans);
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(hs);
//     }
// }


// i thought this might works but it faied
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         // Set<List<Integer>> hs = new HashSet<>();
//         List<List<Integer>> out = new ArrayList<>();
//         int n = nums.length;
//         HashSet<Integer> target = new HashSet<>();

//         for(int i =0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//                 if(target.contains(nums[i] + nums[j])){
//                     List<Integer> ans = new ArrayList<>();
//                     int x = nums[i] + nums[j];
//                     if(x + nums[i] + nums[j] == 0){
//                         ans.add(x);
//                         ans.add(nums[i]);
//                         ans.add(nums[j]);
//                         out.add(ans);
//                     }
//                     target.remove(x);
//                 }
//                 else{
//                     target.add(nums[i] + nums[j]);
//                 }
//             }
//         }
//         return out;
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> out = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    out.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        return out;
    }
}
