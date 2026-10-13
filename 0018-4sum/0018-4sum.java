// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;
//         List<List<Integer>> out = new ArrayList<>();
//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++){
//                 for(int k = j+1; k<n; k++){
//                     for(int l = k+1; l<n; l++){
//                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
//                         if(sum == target){
//                             List<Integer> ans = new ArrayList<>();
//                             ans.add(nums[i]);
//                             ans.add(nums[j]);
//                             ans.add(nums[k]);
//                             ans.add(nums[l]);
//                             Collections.sort(ans);
//                             if(!out.contains(ans)){
//                                 out.add(ans);
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return out;
//     }
// }
 
// this is not works
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;
//         Arrays.sort(nums);        
//         List<List<Integer>>out = new ArrayList<>();
//         for(int i = 0; i<n-3; i++){
//             while(i > 0 && i<n-3 && nums[i] == nums[i-1]){
//                 i++;
//             }
//             for(int j = i+1; j<n-2; j++){
//                 while(j<n-2 && nums[j] == nums[j-1]){
//                     j++;
//                 }

//                 int k = j+1;
//                 int l = n - 1;

//                 while(k < l){
//                      int sum = nums[i] + nums[j] + nums[k] + nums[l];
//                      if(sum == target){
//                         List<Integer> ans = new ArrayList<>();
//                         ans.add(nums[i]);
//                         ans.add(nums[j]);
//                         ans.add(nums[k]);
//                         ans.add(nums[l]);
//                         if(!out.contains(ans)){
//                             out.add(ans);
//                         }
//                         k++;                        
//                     }
//                     else if(sum < target){
//                         k++;
//                     }
//                     else{
//                         l--;
//                     }
//                 }
//             }
//         }

//         return out;
//     }
// }



 class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);        
        List<List<Integer>>out = new ArrayList<>();
        for(int i = 0; i<n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j<n-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k = j+1;
                int l = n - 1;

                while(k < l){
                     long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                     if (sum == target) {
                        out.add(Arrays.asList(
                            nums[i], nums[j], nums[k], nums[l]
                        ));

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }

        return out;
    }
}
 