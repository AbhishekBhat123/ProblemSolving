// this is the brute force approach which i did
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int x: nums){
//             map.put(x, map.getOrDefault(x,0)+1);
//         }

//         int ans[] = new int[k];
//         int idx=0;
//         int cnt = k;
//         while(k-->0){
//             int max = 0;
//             int key = 0;
//             for(int x: map.keySet()){
//                if(map.get(x) > max){
//                 max = map.get(x);
//                 key = x;
//                }
//             }            
//             ans[idx++] = key;
//             map.remove(key);
//         }
//         return ans;
//     }
// }


// Optimal uses: Bucket sort for to store freq
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {

//         // 1. Count frequencies
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int x : nums){
//             map.put(x, map.getOrDefault(x, 0) + 1);
//         }

//         // 2. Create buckets
//         List<Integer>[] bucket = new ArrayList[nums.length + 1];

//         // 3. Put each number into its frequency bucket
//         for(int x : map.keySet()){
//             int freq = map.get(x);

//             if(bucket[freq] == null){
//                 bucket[freq] = new ArrayList<>();
//             }

//             bucket[freq].add(x);
//         }

//         // 4. Get k most frequent elements
//         int[] ans = new int[k];
//         int idx = 0;

//         for(int i = nums.length; i >= 1 && k > 0; i--){

//             if(bucket[i] != null){

//                 for(int x : bucket[i]){
//                     ans[idx++] = x;
//                     k--;

//                     if(k == 0){
//                         break;
//                     }
//                 }
//             }
//         }

//         return ans;
//     }
// }


// this with heap or pq
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         PriorityQueue<Integer> pq = new PriorityQueue<>(
//             (a, b) -> Integer.compare(map.get(b), map.get(a))
//         );

//         for (int key : map.keySet()) {
//             pq.offer(key);
//         }

//         int[] ans = new int[k];

//         for (int i = 0; i < k; i++) {
//             ans[i] = pq.poll();
//         }

//         return ans;
//     }
// }

// better than above
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Calculate frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create Min Heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(map.get(a), map.get(b))
        );

        // Step 3: Maintain heap size K
        for (int key : map.keySet()) {

            pq.offer(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Extract K elements
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}