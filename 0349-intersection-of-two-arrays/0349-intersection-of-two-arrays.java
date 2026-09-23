class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        HashSet<Integer> hs = new HashSet<>();
        for(int x:nums1){
            hs.add(x);
        }
        List<Integer> al = new ArrayList<>();
        
        for(int x: nums2){
            if(hs.contains(x)){
                al.add(x);
            }
                hs.remove(x);            
        }

        int ans[] = new int[al.size()];
        for(int i =0; i<al.size(); i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}
