class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: stones){
            max.offer(n);
        }
        while(max.size() > 1){
            int a = max.poll();
            int b = max.poll();
            if(a-b != 0){
                max.offer(a-b);
            }
        }
        return max.size() == 0? 0: max.peek();
    }
}