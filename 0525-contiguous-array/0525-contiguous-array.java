// class Solution {
//     public int findMaxLength(int[] nums) {
//         int n = nums.length;
//         int max0s = 0;
//         int max1s = 0;
//         int cnt = 0;

//         for(int os: nums){
//             if(os == 0){
//                 cnt++;
//                 max0s = Math.max(max0s, cnt);
//             }
//             else{cnt = 0;}
//         }
//         cnt = 0;
//         for(int ones: nums){
//             if(ones == 1){
//                 cnt++;
//                 max1s = Math.max(max1s, cnt);
//             }
//             else{cnt = 0;}
//         }

//         return 2*(Math.min(max0s, max1s));
//     }
// }

// this is the optimal brute force approach for contiguos problem
// class Solution {
//     public int findMaxLength(int[] nums) {
//        int n = nums.length;
//        int contiguos = 0;
//        for(int i =0; i<n; i++){
//         int zeros = 0;
//         int ones = 0;
//         for(int j = i; j<n; j++){
//             if(nums[j] == 0){zeros++;}
//             else{ones++;}

//             if(zeros == ones){contiguos = Math.max(contiguos, zeros+ones);}
//         }
//        }
//        return contiguos;
//     }
// }

// optimal

class Solution {
    public int findMaxLength(int[] nums) {

        int maxlength = 0;
        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for(int i =0; i<n; i++){
            if(nums[i] == 0){count--;}
            else{count++;}

            if(map.containsKey(count)){
                maxlength = Math.max(maxlength, i- map.get(count));
            }
            else{map.put(count, i);}
        }
        return maxlength;

    }
}
