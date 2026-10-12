class Solution {
    public long countCommas(long n) { 
        long cnt = 1000;
        long commaCount = 0;
        while(cnt <= n){
            commaCount += n - cnt + 1; 
            cnt *= 1000;
        }
        return commaCount;
    }
}
