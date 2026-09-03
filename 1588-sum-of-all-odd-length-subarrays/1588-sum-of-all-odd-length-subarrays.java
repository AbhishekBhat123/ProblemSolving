class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // here we are taking half of the sub arrays and saying that here half of the part is odd if left and right has same parity 
        // u can take any array and u can see as the length of it goes like even,odd,even,... like this 
        // R-L+1 = odd R-L = even
        int sum = 0;
        int n = arr.length;
        for(int i = 0; i< n; i++){
            int total = (i+1)*(n-i);
            int odd = (total + 1)/2;
             sum += arr[i] * odd;
        }
        return sum;
    }
}