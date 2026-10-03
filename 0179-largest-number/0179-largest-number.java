// class Solution {
//     public String largestNumber(int[] nums) {

//         String[] arr = new String[nums.length];

//         // Convert int → String
//         for (int i = 0; i < nums.length; i++) {
//             arr[i] = String.valueOf(nums[i]);
//         }

//         // Custom sorting
//         Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

//         // Join everything
//         StringBuilder sb = new StringBuilder();

//         for (String s : arr) {
//             sb.append(s);
//         }

//         // Special case: [0,0,0,...]
//         if (sb.charAt(0) == '0') {
//             return "0";
//         }

//         return sb.toString();
//     }
// }




class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        String[] ans = new String[n];

        for(int i =0; i<n; i++){
            ans[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(ans, (a,b)->(b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();

        for(String s: ans){
            sb.append(s);
        }

        if(sb.charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }
}
