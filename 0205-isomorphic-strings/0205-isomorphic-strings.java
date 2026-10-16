class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapST = new int[128];
        int[] mapTS = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapST[a] != mapTS[b]) {
                return false;
            }
            // here we are storing which position those char is seen and checking both of the chars position same or not 
            // 0 → never seen
            // 1 → last seen at index 0
            // 2 → last seen at index 1
            // 3 → last seen at index 2

            mapST[a] = i + 1;
            mapTS[b] = i + 1;
        }

        return true;
    }
}