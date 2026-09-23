class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: nums1){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        List<Integer> temp = new ArrayList<>();

        int cnt = 0;
        for(int x: nums2){
            if(map.containsKey(x)){
                 cnt = map.get(x);
                 temp.add(x);
                        
            if(cnt ==1 ){
                map.remove(x);
            }
            else{
                map.put(x,cnt-1);
            }
            }
        }

        int ans[] = new int[temp.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }
}