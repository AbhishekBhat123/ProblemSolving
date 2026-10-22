// here the approach is correct but there are one more condition that s also dont have to point to pattern twise ex: p = a,b and s= dog, dog it fails
// class Solution {
//     public boolean wordPattern(String pattern, String s) {
//         HashMap<Character, String> map = new HashMap<>();
//         for(int i = 0; i<pattern.length(); i++){
//             char letter = pattern.charAt(i);
//             char word = words()
//             if(map.containsKey(letter)){

//             }
//             else{
//                 map.put(letter, )
//             }
//         }
//     }
// }

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }
}