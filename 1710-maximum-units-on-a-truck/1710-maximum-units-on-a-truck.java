class Solution {
    class box{
        int box;
        int unit;
        box(int b, int u){
            this.box = b;
            this.unit = u;
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<box> ans = new ArrayList<>();
        int n = boxTypes.length;
        for(int i = 0; i<n; i++){
            ans.add(new box(boxTypes[i][0], boxTypes[i][1]));
        }

        Collections.sort(ans, (a,b) -> Integer.compare(b.unit, a.unit));
        int max = 0;

        for(int i = 0; i<n; i++){
            if(truckSize >= ans.get(i).box){
                max += ans.get(i).box * ans.get(i).unit;
                truckSize -= ans.get(i).box;
            }
            else{
                max += truckSize * ans.get(i).unit;
                break;
            }
        }
        return max;

    }
}