
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int sum = 0;
}

class MapSum {

    TrieNode root;
    HashMap<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        // here the idea is instead of updating the value from every node we are just subtracting the value from the val so that we can add those val only ex: if old val is apple:3 and we added each char has that val so instead of replacing that with new val we are subtracting like apple:7 => 7-4 = 3 we add this 
        int oldValue = map.getOrDefault(key, 0);
        int diff = val - oldValue;

        map.put(key, val);

        TrieNode curr = root;

        for (char ch : key.toCharArray()) {

            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];

            curr.sum += diff;
        }
    }

    public int sum(String prefix) {

        TrieNode curr = root;

        for (char ch : prefix.toCharArray()) {

            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                return 0;
            }

            curr = curr.children[idx];
        }

        return curr.sum;
    }
}
