// this is failed
// class Solution {
//     public int characterReplacement(String s, int k) {
//       int n = s.length();
//       int max = 0;
//       int cnt;

//       for(int i = 0; i<n; i++){
//         cnt = 0;
//         int kval = k;
//         for(int j = i; j<n;j++){
//             if(s.charAt(i) != s.charAt(j) && kval==0){
//                break;
//             }             
//             if(s.charAt(i) != s.charAt(j) && kval!=0){
//                 kval--;
//             }                       
//             cnt++;
//             max = Math.max(cnt, max); 
//         }
//       }  
//       return max;
//     }
// }




// working bf
// class Solution {
//     public int characterReplacement(String s, int k) {
//       int n = s.length();
//       int max = 0;
//       int cnt;
     
//      // here actually intenstion is i have to find the length of substring where if i have to replcae k number of character to make it max so 
//      // we have to find length of max frquency of a character present and its length and if i subtract the both length - maxfreq and if i found the value which is quals to k then i can store it as max 
//      // so basically we are finding int the length how many chars were frequently found 
     
//       for(int i = 0; i<n; i++){
//         int freq[] = new int[26];
//         int maxfreq = 0;
//         for(int j = i; j<n; j++){
//             freq[s.charAt(j) - 'A']++;

//                 maxfreq = Math.max(
//                     maxfreq,
//                     freq[s.charAt(j) - 'A']
//                 );

//             int length = j - i + 1;
//             int requirement = length - maxfreq;

//             if(requirement <= k){max = Math.max(max, length);}
//         }
//       }
//         return max;
//     }
// }



// Optimal with sliding window  
class Solution {
    public int characterReplacement(String s, int k) {
      int n = s.length();
      int max = 0;
      int freq[] = new int[26];    
      int left = 0;
      int maxfreq = 0;
      for(int right = 0; right<n; right++){
         freq[s.charAt(right) - 'A']++;
         maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);
         int length = right - left + 1;
         int req = length - maxfreq;

         while(req>k){
            freq[s.charAt(left) - 'A']--;
            left++;
            length = right - left + 1;
            req = length - maxfreq;            
         }

         max = Math.max(max, length);
      }
      return max;
    }
}