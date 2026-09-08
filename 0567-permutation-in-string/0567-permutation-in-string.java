// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();

//         if(n>m){return false;}
        
//         // findout freq of s1
//         int freqs1[] = new int[26];
//         for(int i = 0; i<n; i++){
//             freqs1[s1.charAt(i) - 'a']++;
//         }

//         for(int i= 0; i<=m-n; i++){
//             int freqs2[] = new int[26]; 
//             for(int j = i; j<i+n; j++){                
//                 freqs2[s2.charAt(j) - 'a']++;
//             }
//             int cnt = 0;
//             for(int j = 0; j<26; j++){
//                 if(freqs1[j] == freqs2[j]){
//                    cnt++;                    
//                 }
//                 else{break;}
//                 if(cnt == 26){return true;}
//             }
            
//         }
//         return false;
//     }
// }


// Optimal sliding window
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();

//         if(n > m){return false;}

//         // create first freq array for s1
//         int freqs1[] = new int[26];
//         for(int i = 0; i<n; i++){
//             freqs1[s1.charAt(i) - 'a']++;
//         }

//         // first create new window 
//         int freqs2[] = new int[26];
//         for(int i = 0; i<n; i++){
//             freqs2[s2.charAt(i) - 'a']++;
//         }
//         int s = 0;
//         int e = n;

//         while(e <= m){
//             int cnt = 0;
//             for(int i = 0; i<26; i++){
//                 if(freqs1[i] != freqs2[i]){
//                     break;
//                 }
//                 cnt++;
//                 if(cnt == 26){return true;}
//             }

//             // for shrinking and expanding window
//             if(e<m){
//                 freqs2[s2.charAt(s) - 'a']--;
//                 freqs2[s2.charAt(e) - 'a']++;
//             }
//             s++;
//             e++;
//         }
//         return false;
//     }
// }




class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int freqs1[] = new int[26];

        for(int i =0; i<n; i++){
            freqs1[s1.charAt(i) - 'a']++;
        }

        if(n>m){return false;}

        int freqs2[] = new int[26]; 
        for(int i = 0; i<n; i++){
            freqs2[s2.charAt(i) - 'a']++;
        }

        int s = 0;
        int e = n;

        while(e <= m){
            int cnt = 0;
            for(int i = 0; i<26; i++){
                if(freqs1[i] == freqs2[i]){cnt++;}
                if(cnt == 26){return true;}
            }
            
            if(e<m){
            freqs2[s2.charAt(s) - 'a']--;
            freqs2[s2.charAt(e) - 'a']++;
            }

            e++;
            s++;
        }

        return false;
    }
}