// class Solution {
//     int sum; 
//     private void generate(int index, int[] nums, List<Integer> tmp){
//         // if(index == nums.length){
//         //     int xor = 0;
//         //     for(int i = 0; i<tmp.size(); i++){
//         //         xor ^= tmp.get(i);
//         //     }
//         //     sum += xor;
//         //     return;
//         // }
//         int xor = 0;
//         for (int i = 0; i < tmp.size(); i++) {
//             xor ^= tmp.get(i);
//         }
//         sum += xor;
//         for(int i = index; i<nums.length; i++){
//             tmp.add(nums[i]);
//             generate(i+1, nums, tmp);
//             tmp.remove(tmp.size() - 1);
//         }
//     }
//     public int subsetXORSum(int[] nums) {
//         sum = 0;
//         generate(0, nums, new ArrayList<>());
//         return sum;
//     }
// }
// this works but 

// class Solution {
//     int sum = 0;

//     private void generate(int index, int[] nums, int xor) {

//         sum += xor;

//         for (int i = index; i < nums.length; i++) {
//             generate(i + 1, nums, xor ^ nums[i]);
//         }
//     }

//     public int subsetXORSum(int[] nums) {
//         sum = 0;
//         generate(0, nums, 0);
//         return sum;
//     }
// }



class Solution {
    public int subsetXORSum(int[] nums) {

        int or = 0;

        for (int num : nums) {
            or |= num;
        }

        return or * (1 << (nums.length - 1));
    }
}