class Solution {
    private int steps(int num){
        if(num == 0){return 0;}
        if(num % 2 ==0){
            return 1 + steps(num/2);
        }
        else{
            return 1+ steps(num - 1);
        }

    }
    public int numberOfSteps(int num) {
        return steps(num);
    }
}