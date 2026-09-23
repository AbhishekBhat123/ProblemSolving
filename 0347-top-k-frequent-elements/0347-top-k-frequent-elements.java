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
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        //create bucket for to store freq
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key : map.keySet()){
            int freq = map.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int ans[] = new int[k];
        int idx = 0;

        for(int i =nums.length; i>=1 && k>0; i--){
            if(bucket[i]!= null){

                for(int x : bucket[i]){
                    ans[idx++] = x;
                    k--;

                    if(k == 0){break;}
                }
            }
        }

        return ans;
        
    }
}