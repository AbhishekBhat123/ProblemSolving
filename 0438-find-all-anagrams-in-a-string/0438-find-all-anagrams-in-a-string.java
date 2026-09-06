// // brute force
// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> ans = new ArrayList<>();
//         int n = s.length();
//         int m = p.length();

//         // findout the freq of chars in string p
//         int[] freqp = new int[26];
//         for(int i = 0; i<m; i++){
//             freqp[p.charAt(i) - 'a']++;
//         }


//         // compare the m sets in the s string to findout the number of anagrams 
//         for(int i = 0; i<= n-m; i++){
//             int[] freqS = new int[26];

//             for(int j = i; j<i+m; j++){
//                 // now store these sets inside the freq array
//                 freqS[s.charAt(j) - 'a']++;
//             }

//             // now compare the anagrams 
//             boolean anagrams = true;

//             for(int j = 0; j<26; j++){
//                 if(freqS[j] != freqp[j]){
//                     anagrams = false;
//                     break;
//                 } 
//             }

//             if(anagrams){
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
// }



// Optimal with sliding window but this is 80% optimal due to in the while count i am calculating the window repeatatevely 
// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> ans = new ArrayList<>();
//         int n = s.length();
//         int m = p.length();

//         // this is for creating freq of string p
//         int[] freqp = new int[26];
//         for(int i = 0; i<m; i++){
//             freqp[p.charAt(i)- 'a']++;
//         }

//         // intialize the window and apply it to the s 
//         int start = 0; 
//         int end = m;

//         while(end<=n){
//             int[] freqs = new int[26];
//             int count = start;
//             while(count<end){
//                 freqs[s.charAt(count) - 'a']++;
//                 count++;
//             }
//             boolean anagram = true;

//             for(int i = 0; i<26; i++){
//                 if(freqp[i]!= freqs[i]){anagram = false; break;}
//             }

//             if(anagram){ans.add(start);}
//             start++;
//             end++;
//         }

//         return ans;
//     }
// }



// 100% optimal
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) {
            return ans;
        }

        // Frequency of characters in p
        int[] freqP = new int[26];

        for (int i = 0; i < m; i++) {
            freqP[p.charAt(i) - 'a']++;
        }

        // Frequency of current window in s
        int[] freqS = new int[26];

        // Create the first window
        for (int i = 0; i < m; i++) {
            freqS[s.charAt(i) - 'a']++;
        }

        int start = 0;
        int end = m;

        while (end <= n) {

            // Compare frequencies
            boolean anagram = true;

            for (int i = 0; i < 26; i++) {
                if (freqP[i] != freqS[i]) {
                    anagram = false;
                    break;
                }
            }

            if (anagram) {
                ans.add(start);
            }

            // Move window
            if (end < n) {
                freqS[s.charAt(start) - 'a']--;
                freqS[s.charAt(end) - 'a']++;
            }

            start++;
            end++;
        }

        return ans;
    }
}