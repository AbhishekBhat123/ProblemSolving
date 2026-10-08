// class Solution {
//     public String frequencySort(String s) {
//         // if(s.length() == 1){return s;}
//         HashMap<Character, Integer> map = new HashMap<>();

//         for(char ch: s.toCharArray()){
//             map.put(ch, map.getOrDefault(ch, 0) + 1);
//         }

//         Character temp[] = new Character[s.length()];
//         int idx = 0;
//         for(char ch: s.toCharArray()){
//             temp[idx++] = ch;
//         }

//         Arrays.sort(temp, (a,b) ->  Integer.compare(map.get(b), map.get(a)));

//         String result = "";

//         for(char ch : temp){
//             result += ch;
//         }

//         return result;

//     }
// }

class Solution {
    public String frequencySort(String s) {
        // if(s.length() == 1){return s;}
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Character temp[] = new Character[s.length()];
        int idx = 0;
        for(char ch: s.toCharArray()){
            temp[idx++] = ch;
        }

        Arrays.sort(temp, (a,b) ->  {
            int result = Integer.compare(map.get(b), map.get(a));
            if(result == 0){
                return b.compareTo(a);
            }
            return result;
        });

        StringBuilder result = new StringBuilder();

        for(char ch : temp){
            result.append(ch);
        }

        return result.toString();

    }
}