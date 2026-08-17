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


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // balance 0 exists before the array starts
        map.put(0, -1);

        int balance = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                balance--;
            } else {
                balance++;
            }

            if (map.containsKey(balance)) {
                // Same balance → equal number of 0s and 1s in between
                int length = i - map.get(balance);
                maxLength = Math.max(maxLength, length);
            } else {
                // Store only the FIRST occurrence
                map.put(balance, i);
            }
        }

        return maxLength;
    }
}