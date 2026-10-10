// class Solution {
//     private int min(int A[]){
//         int min = A[0];
//         for(int n: A){  
//             min = Math.min(min, n);
//         }
//         return min;
//     }
//     private int max(int A[]){
//         int max = A[0];
//         for(int n: A){
//             max = Math.max(max, n);
//         }
//         return max;
//     }

//     private int check(int A[], int k){
//         int cnt = 0;
//         for(int n: A){
//             int val = n;
//             while(val != 0){
//                 val /= k;
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
//     public int minEatingSpeed(int[] piles, int h) {
//         int l = min(piles);
//         int r = max(piles);
//         int ans = 0;
//         while(l <= r){
//             int mid = l + (r - l)/2;
//             int check = check(piles, mid);
//             if(check <= h){
//                 ans = mid;
//                 l = mid + 1;
//             }
//             else{
//                 r = mid - 1;
//             }
//         }
//         return ans;
//     }
// }

// in the above code i was having the issue of integer division it will work if pile is 7 and k = 4 but if pile is 10 then k = 4 it will provide 10/4 = 2 but we wanted 3 as answer it is not giving ceil value so (n + k - 1)/k


class Solution {
    private long check(int[] piles, int k) {
        long cnt = 0;

        for (int n : piles) {
            cnt += (n + k - 1) / k;
        }

        return cnt;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int n : piles) {
            r = Math.max(r, n);
        }

        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long hours = check(piles, mid);

            if (hours <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}