class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        // pointer 
        int left = 0;
        int right = 0;

        while(left<n && right<m){
            if(s.charAt(left) == t.charAt(right)){
                left++;
                right++;
            }
            else{right++;}
        }

        return left==n;
    }
}