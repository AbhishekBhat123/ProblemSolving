class Solution {
    public int countCommas(int n) {
        int count = 0;
        long start = 1000;
        int comma = 1;

        while(start <= n){
            count += (n - start + 1) * comma;
            start *= 1000;
        }

        return count;
    }
}