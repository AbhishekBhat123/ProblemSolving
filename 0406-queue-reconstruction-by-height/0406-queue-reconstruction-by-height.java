// here the idea is as per question given suppose [7,1] it says that i must have the 1 elemet which has height >= myheight so this type of output we need
// so here we do sorting because it wont affect k value because if i say if [7,0][7,1][5,2] here if u see 5 wont get problem because in the front it has 2 values more than its height
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{            
            if(a[0] != b[0]){
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> ans = new ArrayList<>();
        for(int[] person: people){
            ans.add(person[1], person);
        }
        return ans.toArray(new int[people.length][]);
    }
}