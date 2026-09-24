class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        // freq: 1:3, 2:2, 3:1
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int x: map.keySet()){
            int freq = map.get(x);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(x);
        }

        int idx = 0;
        int ans[] = new int[k];
        for(int i = nums.length; i>=1 && k>0; i--){
            if(bucket[i] != null){
                for(int x: bucket[i]){
                ans[idx++] = x;
                k--;

                if(k==0){break;}
                }                
            }
        }
        return ans;
    }
}