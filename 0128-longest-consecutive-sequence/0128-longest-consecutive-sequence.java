class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Long> hs = new HashSet<>();
        for(long x : nums){
            hs.add(x);
        }
        int max = 0;

        for(long x: hs){
            if(!hs.contains(x-1)){
                int length = 1;
                long cnt = x;

                while(hs.contains(cnt+1)){
                    length++;
                    cnt++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }
}