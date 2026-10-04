// class Solution {
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         int ans[] = new int[arr1.length];
//         int idx =0;
//         int freq[] = new int[1001];

//         for(int n : arr1){
//             freq[n]++;
//         }

//         for(int n: arr2){
//             while(freq[n] > 0){
//                 ans[idx++] = n;
//                 freq[n]--;
//             }
//         }

//         for(int i = 0; i<1001; i++){
//             while(freq[i] > 0){
//                 ans[idx++] = i;
//                 freq[i]--;
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] priority = new int[1001];

        // Give all numbers a default priority
        Arrays.fill(priority, 1001);

        // Numbers in arr2 get priority according to their position
        for (int i = 0; i < arr2.length; i++) {
            priority[arr2[i]] = i;
        }

        // Convert int[] to Integer[]
        Integer[] arr = new Integer[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> {

            // Both numbers are present in arr2
            if (priority[a] != 1001 && priority[b] != 1001) {
                return Integer.compare(priority[a], priority[b]);
            }

            // a is in arr2, b is not
            if (priority[a] != 1001) {
                return -1;
            }

            // b is in arr2, a is not
            if (priority[b] != 1001) {
                return 1;
            }

            // Neither is in arr2
            return Integer.compare(a, b);
        });

        // Convert back to int[]
        int[] ans = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }
}
