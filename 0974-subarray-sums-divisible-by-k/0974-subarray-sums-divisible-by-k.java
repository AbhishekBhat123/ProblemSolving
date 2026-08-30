// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
        
//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 int sum = 0;
//                 for(int l = i; l<=j; l++){
//                     sum += nums[l];
//                 }
//                 if(sum % k == 0){cnt++;}
//             }
//         }
//         return cnt;
//     }
// }


// BF:2 using pf[] and 2 loops
// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
//         int pref[] = new int[n];
//         pref[0] = nums[0];

//         // create pref array
//         for(int i = 1; i<n; i++){
//             pref[i] = pref[i-1] + nums[i];
//         }


//         for(int i = 0; i<n; i++){
//             for(int j = i; j<n; j++){
//                 int sum = 0;
//                 if(i==0){sum = pref[j];}
//                 else{sum = pref[j] - pref[i-1];}
//                 if(sum % k == 0){cnt++;}
//             }
//         }
//         return cnt;
//     }
// }


// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n  = nums.length;
//         int prefixsum = 0;
//         // this is for storing the remainders
//         int count[] = new int[k];

//         int ans = 0; 

//         // this is for storing the prefix value say it is true that 0 % k = 0 so 0 is present as 1
//         count[0] = 1;

//         for(int num: nums){
//             prefixsum += num;
//             int remainder = prefixsum % k;

//             if(remainder<0){
//                 remainder += k;
//             }

//             ans += count[remainder];
//             count[remainder]++;
//         }

//         return ans;
    
//     }
// }





class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       int n = nums.length;
       int totalsum = 0;
       int cnt = 0;
       
       // for to store the freq and freq
       HashMap<Integer, Integer> map = new HashMap<>();

       int pref[] = new int[n];
       pref[0] = nums[0];
       for(int i = 1; i<n; i++){
        pref[i] = pref[i-1] + nums[i];
       }

       map.put(0,1);
       for(int i = 0; i<n; i++){
        int need = pref[i] % k;

        if(need < 0){need += k;}

        if(map.containsKey(need)){
            cnt += map.get(need);
        }

        map.put(need, map.getOrDefault(need, 0)+1);
       }

       return cnt;
    
    }
}