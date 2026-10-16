class Solution {
    private boolean pal(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while(l < r){
            while(s.charAt(l) != s.charAt(r)){
                return pal(s, l+1, r) || pal(s, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }
}