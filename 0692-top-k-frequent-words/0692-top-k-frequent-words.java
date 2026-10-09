class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        for(int i = 0; i<n; i++){
            StringBuilder word = new StringBuilder();
            for(char ch: words[i].toCharArray()){
                word.append(ch);
            }
            map.put(word.toString(), map.getOrDefault(word.toString(), 0) + 1);
        }

        Arrays.sort(words, (a,b) ->{
            int result = Integer.compare(map.get(b), map.get(a));
            if(result == 0){
                return a.compareTo(b);
            }
            return result;
        });

        List<String> ans = new ArrayList<>();

        for(int i = 0; i<n-1 && k>0; i++){
            if(!words[i].equals(words[i+1])){
                ans.add(words[i]);
                k--;
            }
        }
            if(k>0){
                ans.add(words[n-1]);
            }     

        return ans;
    }
}