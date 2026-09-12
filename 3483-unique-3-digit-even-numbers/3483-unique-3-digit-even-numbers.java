// class Solution {
//     public int totalNumbers(int[] digits) {
//         int[] freq = new int[10];

//         for (int digit : digits) {
//             freq[digit]++;
//         }

//         int count = 0;

//         for (int first = 1; first <= 9; first++) {
//             if (freq[first] == 0) continue;

//             freq[first]--;

//             for (int second = 0; second <= 9; second++) {
//                 if (freq[second] == 0) continue;

//                 freq[second]--;

//                 for (int third = 0; third <= 8; third += 2) {
//                     if (freq[third] > 0) {
//                         count++;
//                     }
//                 }

//                 freq[second]++;
//             }

//             freq[first]++;
//         }

//         return count;
//     }
// }



class Solution {
    public int totalNumbers(int[] digits) {
       int n = digits.length;
       int freq[] = new int [10];
       int cnt = 0;

       // to add the freq of digigts
       for(int digit:digits){
        freq[digit]++;
       }

       // now we have to select the hundreds
       for(int hundreds = 1; hundreds<=9; hundreds++){
        // to skip the iteration if i found the index as 0
        if(freq[hundreds] == 0){
            continue;
        }

        freq[hundreds]--;

        // now to select the tens

        for(int tens = 0; tens<=9; tens++){
        if(freq[tens] == 0){
            continue;
        }

        freq[tens]--;


        // now to select the units

        for(int unit = 0; unit<= 8; unit +=2){
            if(freq[unit] > 0){cnt++;}
        }
        freq[tens]++;
        
        }

        freq[hundreds]++;
       }

       return cnt;
    }
}
