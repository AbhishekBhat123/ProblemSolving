class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x : nums){
            hs.add(x);
        }
        int max = 0;

        for(int x: hs){ // important i forgotten to write hs here i wrote nums
            if(!hs.contains(x-1)){
                int length = 1;
                int cnt = x;

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