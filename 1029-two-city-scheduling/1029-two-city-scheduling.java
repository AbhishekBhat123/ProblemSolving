// class Solution {
//     public int twoCitySchedCost(int[][] costs) {
//         int sum = 0;
//         int n = costs.length;
//         for(int i = 0; i<n; i++){
//             int a = costs[i][0];
//             int b = costs[i][1];
//             if(a<b){
//                 sum += a;
//             }
//             else{
//                 sum += b;
//             }
//         }
//         return sum;
//     }
// }

// above works only for if we wanted to chose min not n/2
class Solution {
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, (a, b) ->
            Integer.compare(a[0] - a[1], b[0] - b[1])
        );

        int sum = 0;
        int n = costs.length;

        for (int i = 0; i < n; i++) {

            if (i < n / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }

        return sum;
    }
}