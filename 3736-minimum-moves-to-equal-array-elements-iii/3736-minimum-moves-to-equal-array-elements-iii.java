class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int n: nums){
            max = Math.max(max,n);
        }
        int move = 0;
        for(int n: nums){
            move += max - n;
        }
        return move;
    }
}