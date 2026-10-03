class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int ans[] = new int[arr1.length];
        int idx =0;
        int freq[] = new int[1001];

        for(int n : arr1){
            freq[n]++;
        }

        for(int n: arr2){
            while(freq[n] > 0){
                ans[idx++] = n;
                freq[n]--;
            }
        }

        for(int i = 0; i<1001; i++){
            while(freq[i] > 0){
                ans[idx++] = i;
                freq[i]--;
            }
        }
        return ans;
    }
}