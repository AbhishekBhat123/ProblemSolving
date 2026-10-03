class Solution {
    public String customSortString(String order, String s) {
        int freq[] = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(char c: order.toCharArray()){
            int cnt = freq[c-'a'];
            while(cnt >0){
                key.append(c);
                cnt--;
                freq[c-'a']--;
            }
        } 
        for(int i =0; i<26; i++){
            while(freq[i] > 0){
                key.append((char)(i + 'a'));
                freq[i]--;
            }
        }

        return key.toString();

    }
}