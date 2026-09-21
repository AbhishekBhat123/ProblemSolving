// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         int n = strs.length;
//         ArrayList<List<String>> out = new ArrayList<>();
        

//         for(int i = 0; i<n; i++){

//             ArrayList<String> ans = new ArrayList<>();
//             int freq[] = new int[26];
//             String check = strs[i];
//             int size = check.length();
//             for(int j = 0; j<size; j++){
//                 freq[check.charAt(j) - 'a']++;
//             }
//             ans.add(check);

//             for(int k = 0; k<n; k++){
//                 int freqtest[] = new int[26];
//                 String anagram = strs[k];
//                 int sizeana = anagram.length();

//                 for(int l = 0; l<26; l++){
//                     freqtest[anagram.charAt(l) - 'a']++;
//                 }

//                 for(int m = 0; m<26; m++){
//                     int cnt = 0;
//                     if(freqtest[m] != freq[m]){
//                         break;
//                     }
//                     else{cnt++;}
//                     if(cnt == 26){ans.add(anagram);}
//                 }
//             }
//             out.add(ans);
//         }

//         return out;
//     }
// }



// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {

//         int n = strs.length;

//         List<List<String>> ans = new ArrayList<>();
//         boolean[] visited = new boolean[n];

//         for (int i = 0; i < n; i++) {

//             if (visited[i]) {
//                 continue;
//             }

//             List<String> group = new ArrayList<>();

//             // Add the current string
//             group.add(strs[i]);
//             visited[i] = true;

//             // Frequency of strs[i]
//             int[] freq1 = new int[26];

//             for (char c : strs[i].toCharArray()) {
//                 freq1[c - 'a']++;
//             }

//             // Compare with all strings after i
//             for (int j = i + 1; j < n; j++) {

//                 if (visited[j]) {
//                     continue;
//                 }

//                 // Frequency of strs[j]
//                 int[] freq2 = new int[26];

//                 for (char c : strs[j].toCharArray()) {
//                     freq2[c - 'a']++;
//                 }

//                 // Compare frequencies
//                 if (Arrays.equals(freq1, freq2)) {
//                     group.add(strs[j]);
//                     visited[j] = true;
//                 }
//             }

//             ans.add(group);
//         }

//         return ans;
//     }
// }





import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            // Convert frequency array into a unique key
            String key = Arrays.toString(freq);

            // Add string to its anagram group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
