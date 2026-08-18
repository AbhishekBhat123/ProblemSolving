class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();

        int n = s.length();
        // int max = Integer.MIN_VALUE;

        // for(int i =0; i<n; i++){
        //     if(!list.contains(s.charAt(i))){
        //         list.add(s.charAt(i));
        //         max = Math.max(max, (list.size()));
        //     }
        //     else{
        //         list.clear();
        //     }
        // }
        // return max;


        // HashMap<Character, Integer> hm = new HashMap<>();
        // int left = 0;
        // int right = 0;
        // int max = 0;

        // for(right = 0; right<n; right++){
        //     char ch = s.charAt(right);

        //     if(hm.containsKey(ch)){
        //         left = Math.max(left, hm.get(ch)+1);
        //     }

        //     hm.put(ch,right);
        //     max = Math.max(max, right - left + 1);

        // }

        // return max;



        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            left = Math.max(left, lastSeen[ch] + 1);

            lastSeen[ch] = right;

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
   
    }
}