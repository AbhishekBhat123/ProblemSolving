// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         int n = nums.length;
//         int sum = 0;

//         for(int i = 0; i<n-1; i++){
//             sum = nums[i];
//             for(int j = i+1;j<n; j++){
//                 sum += nums[j];
//                 if(sum % k == 0){
//                     return true;
//                 }
//             }
//         }
//         return false;

//     }
// }


// Optimal
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // construct pref sum
        int pref[] = new int[n];
        pref[0] = nums[0];
        for(int i = 1; i<n; i++){
            pref[i] = pref[i-1] + nums[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i<n; i++){
            int remainder =  pref[i] %k;
            int previndex;
            if(map.containsKey(remainder)){
                previndex = map.get(remainder);
                if(i - previndex >=2){
                    return true;
                }
                
            }

            else{
                    map.put(remainder, i);
                }

            
        }

        return false;
    }
}